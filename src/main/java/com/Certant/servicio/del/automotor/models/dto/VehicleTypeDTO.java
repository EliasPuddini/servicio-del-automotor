package com.Certant.servicio.del.automotor.models.dto;

import com.Certant.servicio.del.automotor.models.entities.VehicleType;
import lombok.Getter;

@Getter
public class VehicleTypeDTO {
    private Long id;
    private String name;

    public VehicleTypeDTO(VehicleType vehicleType){
        this.id = vehicleType.getId();
        this.name = vehicleType.getName();
    }
}
