package com.Certant.servicio.del.automotor.models.entities;

import com.Certant.servicio.del.automotor.models.entities.Person.Client;
import com.Certant.servicio.del.automotor.models.entities.Person.Person;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String carPatent;
    private double kilometres;
    @ManyToOne
    private VehicleType vehicleType;
    @ManyToOne
    private Person owner;
    @ManyToOne
    private Model model;
}
