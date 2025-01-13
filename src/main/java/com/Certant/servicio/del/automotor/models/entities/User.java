package com.Certant.servicio.del.automotor.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class User {
    @Id
    private Long id;
    @Column(unique = true)
    private String userName;
    private String password;
    private Boolean isAdmin;
    private Boolean isMechanic;
}
