package com.Certant.servicio.del.automotor.models.dto.Person;

import com.Certant.servicio.del.automotor.models.dto.ContactDTO;
import com.Certant.servicio.del.automotor.models.dto.DocumentDTO;
import com.Certant.servicio.del.automotor.models.dto.UserDTO;
import com.Certant.servicio.del.automotor.models.entities.Person.Person;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class PersonDTO {
    protected String name;
    protected DocumentDTO document;
    protected UserDTO user;
    protected List<ContactDTO> contactList = new ArrayList<>();

    public PersonDTO(Person person){
        this.name = person.getName();
        this.document = new DocumentDTO(person.getDocument());
        this.user = new UserDTO(person.getUser());
        person.getContactList().forEach(contact -> {
            ContactDTO contactDTO = new ContactDTO(contact);
            this.contactList.add(contactDTO);
        });
    }
}
