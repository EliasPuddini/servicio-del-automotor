package com.Certant.servicio.del.automotor.service.implementations;

import com.Certant.servicio.del.automotor.models.dto.MechanicDTO;
import com.Certant.servicio.del.automotor.models.entities.Mechanic;
import com.Certant.servicio.del.automotor.repositories.MechanicRepository;
import com.Certant.servicio.del.automotor.service.MechanicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class MechanicServiceImplementation implements MechanicService {

    @Autowired
    private MechanicRepository mechanicRepository;

    @Override
    public List<MechanicDTO> getAll() {

        List<MechanicDTO> mechanics = new ArrayList<>();
        mechanicRepository.findAll().forEach(mechanic -> {
            mechanics.add(new MechanicDTO(mechanic));
        });
        return mechanics;
    }

    @Override
    public MechanicDTO getByID(Long id) {
        return new MechanicDTO(Objects.requireNonNull(mechanicRepository.findById(id).orElse(null)));
    }

    @Override
    public void DeleteByID(Long id) {
        mechanicRepository.deleteById(id);
    }

    @Override
    public void save(Mechanic mechanic) {
        mechanicRepository.save(mechanic);
    }
}
