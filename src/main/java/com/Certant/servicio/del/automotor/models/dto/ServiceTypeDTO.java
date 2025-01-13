package com.Certant.servicio.del.automotor.models.dto;

import com.Certant.servicio.del.automotor.models.entities.ServiceType;
import lombok.Getter;

@Getter
public class ServiceTypeDTO {
    private String name;

    public ServiceTypeDTO(ServiceType serviceType){
        this.name = serviceType.getName();
    }
}
