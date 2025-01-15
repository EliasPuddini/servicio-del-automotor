package com.Certant.servicio.del.automotor.models.entities;

import com.Certant.servicio.del.automotor.models.entities.Person.Client;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "`order`")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private Time hour;
    @ManyToOne
    private Vehicle vehicle;
    @ManyToOne
    private Client client;
    @ManyToOne
    private Service service;
    private Double finalPrice;
    @ManyToMany
    private List<Bonus> bonus;
}