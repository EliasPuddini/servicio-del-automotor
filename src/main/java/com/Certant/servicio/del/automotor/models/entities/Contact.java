package com.Certant.servicio.del.automotor.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Contact {
    @Column(unique = true)
    private String phone;
    @Column(unique = true)
    private String email;
}