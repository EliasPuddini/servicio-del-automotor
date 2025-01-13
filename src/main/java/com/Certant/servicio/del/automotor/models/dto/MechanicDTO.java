package com.Certant.servicio.del.automotor.models.dto;

import com.Certant.servicio.del.automotor.models.entities.Person.Mechanic;
import lombok.Getter;

@Getter
public class MechanicDTO {
    private String name;
    private DocumentDTO document;
    private UserDTO user;

    public MechanicDTO(Mechanic mechanic){
        this.name = mechanic.getName();
        this.document = new DocumentDTO(mechanic.getDocument());
        this.user = new UserDTO(mechanic.getUser());
    }
}
