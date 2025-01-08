package com.Certant.servicio.del.automotor.models.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
    private Document document;
    @OneToMany(mappedBy = "entity", cascade = CascadeType.ALL)
    private List<Contact> contatList;
    private ClientType clientType;
}
