package com.Certant.servicio.del.automotor.service.implementations;

import com.Certant.servicio.del.automotor.models.dto.OrderDTO;
import com.Certant.servicio.del.automotor.models.entities.Client;
import com.Certant.servicio.del.automotor.models.entities.ClientType;
import com.Certant.servicio.del.automotor.models.entities.Orders;
import com.Certant.servicio.del.automotor.repositories.ClientRepository;
import com.Certant.servicio.del.automotor.repositories.ClientTypeRepository;
import com.Certant.servicio.del.automotor.repositories.OrderRepository;
import com.Certant.servicio.del.automotor.repositories.VehicleRepository;
import com.Certant.servicio.del.automotor.service.OrderService;
import org.hibernate.query.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class OrderServiceImplementation implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ClientTypeRepository clientTypeRepository;
    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public List<OrderDTO> getOrders() {
        List<OrderDTO> orderDTOS = new ArrayList<>();
        orderRepository.findAll().forEach(order -> orderDTOS.add(new OrderDTO(order)));
        return orderDTOS;
    }

    @Override
    public List<OrderDTO> getOrdersByDate(Date date) {
        List<OrderDTO> orderDTOS = new ArrayList<>();
        orderRepository.findAll().stream().filter(order -> order.getDate()==date).forEach(order -> orderDTOS.add(new OrderDTO(order)));
        return orderDTOS;
    }
    @Override
    public List<OrderDTO> getOrdersByClient(Long id){
        List<OrderDTO> orderDTOS = new ArrayList<>();
        orderRepository.findAll().stream().filter(order -> order.getClient().getId()==id).toList()
                .forEach(order -> orderDTOS.add(new OrderDTO(order)));
        return orderDTOS;
    }

    @Override
    public OrderDTO getByID(Long id) {
        return new OrderDTO(Objects.requireNonNull(orderRepository.findAll().stream().filter(order -> order.getId() == id).findFirst().orElse(null)));
    }

    @Override
    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public void saveOrder(Orders order) {

        Client client = clientRepository.findById(order.getClient().getId()).orElse(null);
        Date today = new Date();

        List<Orders> orders = orderRepository.findAll().stream().filter(orders1 -> {
            assert client != null;

            return Objects.equals(orders1.getClient().getId(),client.getId()) && orders1.getDate().before(today);
        }).toList();
        if(orders.size() > 4){
            ClientType clientType = clientTypeRepository.findAll().stream().filter(clientType1 -> Objects.equals(clientType1.getName(), "Premium")).findFirst().orElse(null);
            if(clientType == null){
                ClientType clientType1 = new ClientType();
                clientType1.setName("Premium");
                clientTypeRepository.save(clientType1);
                client.setClientType(clientType1);
            }else{
                client.setClientType(clientType);
            }

            clientRepository.save(client);
        }
        orderRepository.save(order);
    }

    @Override
    public void updateOrder(Long id, Orders order) {
        Orders order1 = orderRepository.findById(id).orElse(null);
        assert order1 != null;
        order1.setService(order.getService());
        order1.setHour(order.getHour());
        order1.setDate(order.getDate());
        order1.setVehicle(order.getVehicle());
        order1.setBonus(order.getBonus());
        order1.setClient(order.getClient());
        order1.setFinalPrice(order.getFinalPrice());
        orderRepository.save(order1);
    }
}
