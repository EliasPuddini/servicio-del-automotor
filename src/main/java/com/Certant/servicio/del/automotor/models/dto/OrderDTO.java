package com.Certant.servicio.del.automotor.models.dto;

import com.Certant.servicio.del.automotor.models.entities.Order;
import lombok.Getter;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
public class OrderDTO {
    private Date date;
    private Time hour;
    private VehicleDTO vehicle;
    private ClientDTO client;
    private ServiceDTO service;
    private double finalPrice;
    private List<BonusDTO> bonus = new ArrayList<>();

    public OrderDTO(Order order){
        this.date = order.getDate();
        this.hour = order.getHour();
        this.vehicle = new VehicleDTO(order.getVehicle());
        this.client = new ClientDTO(order.getClient());
        this.service = new ServiceDTO(order.getService());
        this.finalPrice = order.getFinalPrice();
        order.getBonus().forEach(bonus1 -> {
            BonusDTO bonusDTO = new BonusDTO(bonus1);
            this.bonus.add(bonusDTO);
        });
    }
}
