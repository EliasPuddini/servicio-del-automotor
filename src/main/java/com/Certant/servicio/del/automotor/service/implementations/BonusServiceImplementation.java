package com.Certant.servicio.del.automotor.service.implementations;

import com.Certant.servicio.del.automotor.models.dto.BonusDTO;
import com.Certant.servicio.del.automotor.models.entities.Bonus;
import com.Certant.servicio.del.automotor.repositories.BonusRepository;
import com.Certant.servicio.del.automotor.service.BonusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class BonusServiceImplementation implements BonusService {
    @Autowired
    private BonusRepository bonusRepository;

    @Override
    public List<BonusDTO> getAll() {
        List<BonusDTO> bonusDTOS = new ArrayList<>();
        bonusRepository.findAll().forEach(bonus -> bonusDTOS.add(new BonusDTO(bonus)));
        return bonusDTOS;
    }

    @Override
    public BonusDTO getByID(Long id) {
        return new BonusDTO(Objects.requireNonNull(bonusRepository.findById(id).orElse(null)));
    }

    @Override
    public void save(Bonus bonus) {
        bonusRepository.save(bonus);
    }

    @Override
    public void delete(Long id) {
        Bonus bonus = bonusRepository.findById(id).orElse(null);
        assert bonus != null;
        bonus.setActive(false);
        bonusRepository.save(bonus);
    }

    @Override
    public void updateBonus(Long id, Bonus bonus) {
        Bonus bonus1 = bonusRepository.findById(id).orElse(null);
        assert bonus1 != null;
        bonus1.setService(bonus.getService());
        bonus1.setActive(bonus.isActive());
        bonus1.setBonus(bonus.getBonus());
        bonus1.setPercentaje(bonus.getPercentaje());
        bonusRepository.save(bonus1);
    }
}
