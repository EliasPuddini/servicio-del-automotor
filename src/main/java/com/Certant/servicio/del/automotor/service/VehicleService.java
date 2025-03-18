package com.Certant.servicio.del.automotor.service;

import com.Certant.servicio.del.automotor.models.dto.VehicleDTO;
import com.Certant.servicio.del.automotor.models.entities.Vehicle;

import java.util.List;

public interface VehicleService {
    public List<VehicleDTO> getVehicles();
    public VehicleDTO getVehicle(Long id);
    public void deleteVehicle(Long id);
    public void saveVehicle(Vehicle vehicle);
}
