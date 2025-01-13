package com.Certant.servicio.del.automotor.models.dto;

import com.Certant.servicio.del.automotor.models.entities.VehicleType;
import lombok.Getter;

@Getter
public class VehicleTypeDTO {
    private String name;

    public VehicleTypeDTO(VehicleType vehicleType){
        this.name = vehicleType.getName();
    }
}
