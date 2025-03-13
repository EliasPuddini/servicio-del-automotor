package com.Certant.servicio.del.automotor.service;

import com.Certant.servicio.del.automotor.models.dto.VehicleTypeDTO;
import com.Certant.servicio.del.automotor.models.entities.VehicleType;

import java.util.List;

public interface VehicleTypeService {
    List<VehicleTypeDTO> getAll();
    VehicleTypeDTO getByID(Long id);
    void delete(Long id);
    void save(VehicleType vehicleType);
}
