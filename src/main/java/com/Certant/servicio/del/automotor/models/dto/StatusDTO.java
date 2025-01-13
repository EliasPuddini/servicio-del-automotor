package com.Certant.servicio.del.automotor.models.dto;

import com.Certant.servicio.del.automotor.models.entities.Status;
import lombok.Getter;

@Getter
public class StatusDTO {
    private String status;

    public StatusDTO(Status status){
        this.status = status.getStatus();
    }
}
