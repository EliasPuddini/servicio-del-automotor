package com.Certant.servicio.del.automotor.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Service {
    @Id
    private Long id;
    private String name;
    @ManyToOne
    private ServiceType serviceType;
    private double price;
}
