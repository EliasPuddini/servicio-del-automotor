package com.Certant.servicio.del.automotor.models.entities;

import com.Certant.servicio.del.automotor.models.entities.ClientType;
import com.Certant.servicio.del.automotor.models.entities.Contact;
import com.Certant.servicio.del.automotor.models.entities.Document;
import com.Certant.servicio.del.automotor.models.entities.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Entity
@Table(name = "client")
public class Client{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToOne
    @JoinColumn(name = "document_id", unique = true)
    private Document document;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany
    private List<Contact> contacts;
    @OneToMany
    private List<Vehicle> vehicles;
    @ManyToOne
    @JoinColumn(name = "clientType_id")
    private ClientType clientType;

    public void removeVehicle(Vehicle vehicle){
        this.vehicles.remove(vehicle);
    }
}
