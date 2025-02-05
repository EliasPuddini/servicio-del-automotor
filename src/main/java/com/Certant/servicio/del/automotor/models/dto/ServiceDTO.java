package com.Certant.servicio.del.automotor.models.dto;

import com.Certant.servicio.del.automotor.models.entities.Service;
import lombok.Getter;

@Getter
public class ServiceDTO {
    private String name;

    public ServiceDTO(Service service){
        this.name = service.getName();
    }
}
