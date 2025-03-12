package com.Certant.servicio.del.automotor.models.dto;

import com.Certant.servicio.del.automotor.models.entities.Vehicle;
import lombok.Getter;

@Getter
public class VehicleDTO {
    private Long id;
    private String carPatent;
    private double kilometres;
    private VehicleTypeDTO vehicleType;
    private ModelDTO model;

    public VehicleDTO(Vehicle vehicle){
        this.id = vehicle.getId();
        this.carPatent = vehicle.getCarPatent();
        this.kilometres = vehicle.getKilometres();
        this.vehicleType = new VehicleTypeDTO(vehicle.getVehicleType());
        this.model = new ModelDTO(vehicle.getModel());
    }
}
