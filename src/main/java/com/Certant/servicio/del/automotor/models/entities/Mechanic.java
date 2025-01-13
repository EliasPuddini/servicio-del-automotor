package com.Certant.servicio.del.automotor.models.entities;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Mechanic {
    private String name;
    private Document document;
    private User user;
}
