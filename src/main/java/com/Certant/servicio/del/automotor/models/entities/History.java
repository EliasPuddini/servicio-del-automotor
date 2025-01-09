package com.Certant.servicio.del.automotor.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class History {
    @Id
    private Long id;
    private Date date;
    @OneToMany(fetch  = FetchType.EAGER,mappedBy = "date")
    private List<Order> realizedOrders;
}
