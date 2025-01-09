package com.Certant.servicio.del.automotor.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Client {
    @Id
    private Long id;
    private String name;
    @OneToOne
    @Column(unique = true)
    private Document document;
    @OneToMany
    private List<Contact> contatList;
    @OneToOne
    private ClientType clientType;
}
