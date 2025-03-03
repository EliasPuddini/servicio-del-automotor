package com.Certant.servicio.del.automotor.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "History")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    @ManyToOne
    private Order order;
    @ManyToOne
    private Mechanic mechanic;
    @ManyToOne
    private Status status;
    private String observation;
}
