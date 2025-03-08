package com.Certant.servicio.del.automotor.service.implementations;

import com.Certant.servicio.del.automotor.models.dto.ServiceDTO;
import com.Certant.servicio.del.automotor.repositories.ServiceRepository;
import com.Certant.servicio.del.automotor.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ServiceServiceImplementation implements ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public List<ServiceDTO> getServices() {
        List<ServiceDTO> serviceDTOS = new ArrayList<>();
        serviceRepository.findAll().forEach(service -> {
            serviceDTOS.add(new ServiceDTO(service));
        });
        return serviceDTOS;
    }

    @Override
    public ServiceDTO getServiceByID(Long id) {
        return new ServiceDTO(Objects.requireNonNull(serviceRepository.findAll().stream().filter(service -> Objects.equals(service.getId(), id)).findFirst().orElse(null)));
    }

    @Override
    public void deleteService(Long id) {
        serviceRepository.deleteById(id);
    }

    @Override
    public void saveService(com.Certant.servicio.del.automotor.models.entities.Service service) {
        serviceRepository.save(service);
    }
}
