package com.Certant.servicio.del.automotor.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Vehicle {
    @Id
    private Long id;
    @Column(unique = true)
    private String carPatent;
    private double kilometres;
    @ManyToOne
    private VehicleType vehicleType;
    @ManyToOne
    private Client owner;
    @ManyToOne
    private Model model;
}
