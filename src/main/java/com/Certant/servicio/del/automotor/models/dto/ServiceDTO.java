package com.Certant.servicio.del.automotor.models.dto;

import com.Certant.servicio.del.automotor.models.entities.Service;
import lombok.Getter;

@Getter
public class ServiceDTO {
    private String name;
    private ServiceTypeDTO serviceTypeDTO;
    private double price;

    public ServiceDTO(Service service){
        this.name = service.getName();
        this.price = service.getPrice();
        this.serviceTypeDTO = new ServiceTypeDTO(service.getServiceType());
    }
}
