package com.Certant.servicio.del.automotor.models.dto;

import com.Certant.servicio.del.automotor.models.entities.Brand;
import lombok.Getter;

@Getter
public class BrandDTO {
    private Long id;
    private String name;

    public BrandDTO(Brand brand){
        this.id = brand.getId();
        this.name = brand.getName();
    }
}
