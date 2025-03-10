package com.Certant.servicio.del.automotor.models.entities;

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
@Table(name = "mechanic")
public class Mechanic{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToOne
    @JoinColumn(unique = true)
    private Document document;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany()
    private List<Contact> contactList;
    private String availability;//como lunes a viernes en tal y tal horario
}
