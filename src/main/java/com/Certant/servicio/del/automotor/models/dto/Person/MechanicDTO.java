package com.Certant.servicio.del.automotor.models.dto.Person;

import com.Certant.servicio.del.automotor.models.dto.ClientTypeDTO;
import com.Certant.servicio.del.automotor.models.dto.ContactDTO;
import com.Certant.servicio.del.automotor.models.dto.DocumentDTO;
import com.Certant.servicio.del.automotor.models.dto.UserDTO;
import com.Certant.servicio.del.automotor.models.entities.Person.Mechanic;
import lombok.Getter;

@Getter
public class MechanicDTO extends PersonDTO{
    private String availability;

    public MechanicDTO(Mechanic mechanic){
        this.availability = mechanic.getAvailability();
        this.name = mechanic.getName();
        this.document = new DocumentDTO(mechanic.getDocument());
        this.user = new UserDTO(mechanic.getUser());

        mechanic.getContactList().forEach(contact -> {
            ContactDTO contactDTO = new ContactDTO(contact);
            contactList.add(contactDTO);
        });
    }
}
