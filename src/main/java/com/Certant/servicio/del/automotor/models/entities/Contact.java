package com.Certant.servicio.del.automotor.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "contact")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String phone;
    @Column(unique = true)
    private String email;
}