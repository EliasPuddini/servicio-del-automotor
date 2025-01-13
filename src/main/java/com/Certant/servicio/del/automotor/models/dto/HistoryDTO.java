package com.Certant.servicio.del.automotor.models.dto;

import com.Certant.servicio.del.automotor.models.dto.Person.MechanicDTO;
import com.Certant.servicio.del.automotor.models.entities.History;
import lombok.Getter;

import java.util.Date;

@Getter
public class HistoryDTO {
    private Date date;
    private OrderDTO order;
    private MechanicDTO mechanic;
    private StatusDTO status;
    private String observation;

    public HistoryDTO(History history){
        this.date = history.getDate();
        this.order = new OrderDTO(history.getOrder());
        this.mechanic = new MechanicDTO(history.getMechanic());
        this.status = new StatusDTO(history.getStatus());
        this.observation = history.getObservation();
    }
}
