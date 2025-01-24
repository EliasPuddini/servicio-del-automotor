package com.Certant.servicio.del.automotor.service.implementations;

import com.Certant.servicio.del.automotor.models.dto.OrderDTO;
import com.Certant.servicio.del.automotor.models.entities.Order;
import com.Certant.servicio.del.automotor.repositories.OrderRepository;
import com.Certant.servicio.del.automotor.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class OrderServiceImplementation implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

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
    public void saveOrder(Order order) {
        orderRepository.save(order);
    }
}
