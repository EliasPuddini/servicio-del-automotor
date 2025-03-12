package com.Certant.servicio.del.automotor.models.dto;

import com.Certant.servicio.del.automotor.models.entities.Model;
import lombok.Getter;

@Getter
public class ModelDTO {
    private Long id;
    private String name;
    private BrandDTO brand;

    public ModelDTO(Model model){
        this.id = model.getId();
        this.name = model.getName();
        this.brand = new BrandDTO(model.getBrand());
    }
}
