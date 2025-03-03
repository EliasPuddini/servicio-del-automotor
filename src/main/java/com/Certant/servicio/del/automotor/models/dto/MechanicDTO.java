package com.Certant.servicio.del.automotor.models.dto;

import com.Certant.servicio.del.automotor.models.dto.ContactDTO;
import com.Certant.servicio.del.automotor.models.dto.DocumentDTO;
import com.Certant.servicio.del.automotor.models.dto.UserDTO;
import com.Certant.servicio.del.automotor.models.entities.Mechanic;
import lombok.Getter;

import java.util.List;

@Getter
public class MechanicDTO{
    private String name;
    private DocumentDTO documentDTO;
    private List<ContactDTO> contacts;
    private String availability;

    public MechanicDTO(Mechanic mechanic){
        this.availability = mechanic.getAvailability();
        this.name = mechanic.getName();
        this.documentDTO = new DocumentDTO(mechanic.getDocument());

        mechanic.getContactList().forEach(contact -> {
            ContactDTO contactDTO = new ContactDTO(contact);
            contacts.add(contactDTO);
        });
    }
}
