package com.Certant.servicio.del.automotor.models.entities;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Contact {
    private String telefono;
    private String email;
}