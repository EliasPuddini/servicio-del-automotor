package com.Certant.servicio.del.automotor.models.dto;

import com.Certant.servicio.del.automotor.models.entities.Status;
import lombok.Getter;

@Getter
public class StatusDTO {
    private Long id;
    private String name;

    public StatusDTO(Status status){
        this.id = status.getId();
        this.name = status.getName();
    }
}
