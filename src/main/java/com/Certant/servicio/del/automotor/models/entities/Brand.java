package com.Certant.servicio.del.automotor.models.entities;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Brand {
    private String name;
}
