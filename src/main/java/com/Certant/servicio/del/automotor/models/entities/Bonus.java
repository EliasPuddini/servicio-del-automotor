package com.Certant.servicio.del.automotor.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Bonus {
    @Id
    private Long id;
    private double bonus;
    @ManyToOne
    private Service service;
    private double percentaje;
    private boolean isActive;
}
