package com.Certant.servicio.del.automotor.service;

import com.Certant.servicio.del.automotor.models.dto.ServiceDTO;
import com.Certant.servicio.del.automotor.models.entities.Service;

import java.util.List;

public interface ServiceService {
    List<ServiceDTO> getServices();
    ServiceDTO getServiceByID(Long id);
    void deleteService(Long id);
    void saveService(Service service);
}
