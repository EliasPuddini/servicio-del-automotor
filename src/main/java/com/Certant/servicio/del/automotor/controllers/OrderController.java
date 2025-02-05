package com.Certant.servicio.del.automotor.controllers;

import com.Certant.servicio.del.automotor.models.dto.OrderDTO;
import com.Certant.servicio.del.automotor.models.entities.Order;
import com.Certant.servicio.del.automotor.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAll(){
        try{
            List<OrderDTO> orders = orderService.getOrders();
            return ResponseEntity.status(HttpStatus.OK).body(orders);
        }catch(Exception ignored){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/{orderID}")
    public ResponseEntity<OrderDTO> getByID(@PathVariable("orderID") Long id){
        try{
            OrderDTO order = orderService.getByID(id);
            return ResponseEntity.status(HttpStatus.OK).body(order);
        }catch(Exception ignored){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<String> saveOrder(@RequestBody Order order){
        try{
            orderService.saveOrder(order);
            return ResponseEntity.status(HttpStatus.OK).body("Order saved successfully");
        }catch(Exception ignored){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not saved");
        }
    }

    @DeleteMapping("/{orderID}")
    public ResponseEntity<String> deleteOrder(@PathVariable("orderID") Long id){
        try{
            orderService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Order deleted successfully");
        }catch(Exception ignored){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not deleted");
        }
    }

    @PutMapping("/{userID}")
    public ResponseEntity<?> updateUser(@PathVariable("userID") Long orderID, @RequestBody @Validated Order order) {
        try {
            orderService.updateOrder(orderID,order);
            return ResponseEntity.status(HttpStatus.OK).body("Order with ID: "+ orderID+" updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Error updating order with ID: " + orderID);
        }
    }
}
