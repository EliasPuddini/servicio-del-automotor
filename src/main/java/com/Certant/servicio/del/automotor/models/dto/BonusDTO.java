package com.Certant.servicio.del.automotor.models.dto;

import com.Certant.servicio.del.automotor.models.entities.Bonus;
import lombok.Getter;

@Getter
public class BonusDTO {
    private double bonus;
    private ServiceDTO service;
    private double percentage;
    private Boolean isActive;

    public BonusDTO(Bonus bonus){
        this.bonus = bonus.getBonus();
        this.percentage = bonus.getPercentaje();
        this.isActive = bonus.isActive();
        this.service = new ServiceDTO(bonus.getService());
    }
}
