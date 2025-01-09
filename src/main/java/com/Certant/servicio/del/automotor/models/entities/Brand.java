package com.Certant.servicio.del.automotor.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Brand {
    @Column(unique = true)
    private String name;
}
