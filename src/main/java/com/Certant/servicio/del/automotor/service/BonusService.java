package com.Certant.servicio.del.automotor.service;

import com.Certant.servicio.del.automotor.models.dto.BonusDTO;
import com.Certant.servicio.del.automotor.models.entities.Bonus;

import java.util.List;

public interface BonusService {
    List<BonusDTO> getAll();
    BonusDTO getByID(Long id);
    void save(Bonus bonus);
    void delete(Long id);
    void updateBonus(Long id, Bonus bonus);
}
