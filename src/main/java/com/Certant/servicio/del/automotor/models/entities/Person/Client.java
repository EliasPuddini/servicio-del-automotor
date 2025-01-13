package com.Certant.servicio.del.automotor.models.entities.Person;

import com.Certant.servicio.del.automotor.models.entities.ClientType;
import com.Certant.servicio.del.automotor.models.entities.Contact;
import com.Certant.servicio.del.automotor.models.entities.Document;
import com.Certant.servicio.del.automotor.models.entities.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Client extends Person{
    @OneToOne
    @JoinColumn(name = "clientType_id")
    private ClientType clientType;
}
