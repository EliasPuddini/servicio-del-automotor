package com.Certant.servicio.del.automotor.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class History {
    @Id
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
