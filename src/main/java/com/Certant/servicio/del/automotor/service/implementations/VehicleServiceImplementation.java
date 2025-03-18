package com.Certant.servicio.del.automotor.service.implementations;

import com.Certant.servicio.del.automotor.models.dto.VehicleDTO;
import com.Certant.servicio.del.automotor.models.entities.Client;
import com.Certant.servicio.del.automotor.models.entities.Vehicle;
import com.Certant.servicio.del.automotor.repositories.ClientRepository;
import com.Certant.servicio.del.automotor.repositories.VehicleRepository;
import com.Certant.servicio.del.automotor.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImplementation implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Override
    public List<VehicleDTO> getVehicles() {
        List<VehicleDTO> vehicleDTOS = new ArrayList<>();
        vehicleRepository.findAll().forEach(vehicle -> {
            vehicleDTOS.add(new VehicleDTO(vehicle));
        });

        return vehicleDTOS;
    }

    @Override
    public VehicleDTO getVehicle(Long id) {
        return new VehicleDTO(Objects.requireNonNull(vehicleRepository.findById(id).orElse(null)));
    }

    @Override
    public void deleteVehicle(Long id) {
        Vehicle vehicle = vehicleRepository.findById(id).orElse(null);
        clientRepository.findAll().forEach(client -> {
            if(client.getVehicles().contains(vehicle)){
                client.removeVehicle(vehicle);
            }
            clientRepository.save(client);
        });
        vehicleRepository.deleteById(id);
    }

    @Override
    public void saveVehicle(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
    }
}
