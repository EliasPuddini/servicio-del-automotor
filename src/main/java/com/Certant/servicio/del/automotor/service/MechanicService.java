package com.Certant.servicio.del.automotor.service;

import com.Certant.servicio.del.automotor.models.dto.MechanicDTO;
import com.Certant.servicio.del.automotor.models.entities.Mechanic;

import java.util.List;

public interface MechanicService {
    public List<MechanicDTO> getAll();
    public MechanicDTO getByID(Long id);
    public void DeleteByID(Long id);
    public void save(Mechanic mechanic);
}
