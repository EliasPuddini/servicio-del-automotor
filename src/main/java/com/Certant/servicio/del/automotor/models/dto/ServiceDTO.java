package com.Certant.servicio.del.automotor.models.dto;

import com.Certant.servicio.del.automotor.models.entities.Service;
import lombok.Getter;

@Getter
public class ServiceDTO {
    private Long id;
    private String name;

    public ServiceDTO(Service service){
        this.id = service.getId();
        this.name = service.getName();
    }
}
