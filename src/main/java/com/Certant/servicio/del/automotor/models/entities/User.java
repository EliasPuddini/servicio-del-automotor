package com.Certant.servicio.del.automotor.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Setter;

@Setter
@Entity
public class User {
    @Id
    private Long id;
    private String password;
    private Boolean isAdmin;
}
