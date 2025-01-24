package com.Certant.servicio.del.automotor.service;

import com.Certant.servicio.del.automotor.models.dto.OrderDTO;
import com.Certant.servicio.del.automotor.models.entities.Order;

import java.util.Date;
import java.util.List;

public interface OrderService {
    public List<OrderDTO> getOrders();
    public List<OrderDTO> getOrdersByDate(Date date);
    public List<OrderDTO> getOrdersByClient(Long id);
    public OrderDTO getByID(Long id);
    public void deleteById(Long id);
    public void saveOrder(Order order);
}
