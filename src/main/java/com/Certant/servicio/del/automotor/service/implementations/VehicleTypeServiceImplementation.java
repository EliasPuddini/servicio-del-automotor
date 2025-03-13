package com.Certant.servicio.del.automotor.service.implementations;

import com.Certant.servicio.del.automotor.models.dto.VehicleTypeDTO;
import com.Certant.servicio.del.automotor.models.entities.VehicleType;
import com.Certant.servicio.del.automotor.repositories.VehicleTypeRepository;
import com.Certant.servicio.del.automotor.service.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class VehicleTypeServiceImplementation implements VehicleTypeService {

    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;

    @Override
    public List<VehicleTypeDTO> getAll() {

        List<VehicleTypeDTO> vehicleTypeDTOList = new ArrayList<>();
        vehicleTypeRepository.findAll().forEach(vehicleType -> {
            vehicleTypeDTOList.add(new VehicleTypeDTO(vehicleType));
        });

        return vehicleTypeDTOList;
    }

    @Override
    public VehicleTypeDTO getByID(Long id) {
        return new VehicleTypeDTO(Objects.requireNonNull(vehicleTypeRepository.findById(id).orElse(null)));
    }

    @Override
    public void delete(Long id) {
        vehicleTypeRepository.deleteById(id);
    }

    @Override
    public void save(VehicleType vehicleType) {
        vehicleTypeRepository.save(vehicleType);
    }
}
