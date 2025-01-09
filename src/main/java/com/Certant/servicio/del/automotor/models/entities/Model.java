package com.Certant.servicio.del.automotor.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Model {
    @Id
    private Long id;
    private String name;
    @ManyToOne
    private Brand brand;
}
