package com.Certant.servicio.del.automotor.models.dto;

import com.Certant.servicio.del.automotor.models.dto.Person.ClientDTO;
import com.Certant.servicio.del.automotor.models.dto.Person.PersonDTO;
import com.Certant.servicio.del.automotor.models.entities.Vehicle;
import lombok.Getter;

@Getter
public class VehicleDTO {
    private String carPatent;
    private double kilometres;
    private VehicleTypeDTO vehicleType;
    private PersonDTO owner;
    private ModelDTO model;

    public VehicleDTO(Vehicle vehicle){
        this.carPatent = vehicle.getCarPatent();
        this.kilometres = vehicle.getKilometres();
        this.vehicleType = new VehicleTypeDTO(vehicle.getVehicleType());
        this.owner = new PersonDTO(vehicle.getOwner());
        this.model = new ModelDTO(vehicle.getModel());
    }
}
