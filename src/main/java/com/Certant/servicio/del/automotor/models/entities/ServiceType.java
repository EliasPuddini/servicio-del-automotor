package com.Certant.servicio.del.automotor.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class ServiceType {
    @Id
    private Long id;
    @Column(unique = true)
    private String name;
}
