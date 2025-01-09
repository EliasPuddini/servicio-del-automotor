package com.Certant.servicio.del.automotor.models.entities;

import jakarta.persistence.Column;

public class VehicleType {
    @Column(unique = true)
    private String name;
}
