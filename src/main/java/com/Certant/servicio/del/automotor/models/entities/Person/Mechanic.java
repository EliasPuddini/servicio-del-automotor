package com.Certant.servicio.del.automotor.models.entities.Person;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Mechanic extends Person{
    private String availability;//como lunes a viernes en tal y tal horario
}
