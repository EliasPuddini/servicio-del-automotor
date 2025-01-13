package com.Certant.servicio.del.automotor.models.dto;

import com.Certant.servicio.del.automotor.models.entities.History;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Getter
public class HistoryDTO {
    private Date date;
    private List<OrderDTO> realizedOrders;

    public HistoryDTO(History history){
        this.date = history.getDate();
        history.getRealizedOrders().forEach(order -> {
            OrderDTO orderDTO = new OrderDTO(order);
            this.realizedOrders.add(orderDTO);
        });
    }
}
