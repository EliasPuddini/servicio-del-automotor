package com.Certant.servicio.del.automotor.models.entities;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleType {
    @Column(unique = true)
    private String name;
}
