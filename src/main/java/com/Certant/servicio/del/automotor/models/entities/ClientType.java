package com.Certant.servicio.del.automotor.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class ClientType {
    @Column(unique = true)
    private String name;
}
