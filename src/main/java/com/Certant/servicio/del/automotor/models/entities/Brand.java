package com.Certant.servicio.del.automotor.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "brand")
@Data
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
}
