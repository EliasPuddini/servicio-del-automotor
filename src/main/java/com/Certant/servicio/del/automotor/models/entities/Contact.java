package com.Certant.servicio.del.automotor.models.entities;

import com.Certant.servicio.del.automotor.models.entities.Person.Client;
import com.Certant.servicio.del.automotor.models.entities.Person.Person;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
    @Column(unique = true)
    private String phone;
    @Column(unique = true)
    private String email;
}