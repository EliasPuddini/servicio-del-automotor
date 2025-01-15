package com.Certant.servicio.del.automotor.models.dto.Person;

import com.Certant.servicio.del.automotor.models.dto.ClientTypeDTO;
import com.Certant.servicio.del.automotor.models.dto.ContactDTO;
import com.Certant.servicio.del.automotor.models.dto.DocumentDTO;
import com.Certant.servicio.del.automotor.models.dto.UserDTO;
import com.Certant.servicio.del.automotor.models.entities.Person.Client;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ClientDTO extends PersonDTO{

    private ClientTypeDTO clientType;

    public ClientDTO(Client client){
        super(client);
        this.name = client.getName();
        this.document = new DocumentDTO(client.getDocument());
        this.user = new UserDTO(client.getUser());

        this.clientType = new ClientTypeDTO(client.getClientType());

        client.getContactList().forEach(contact -> {
            ContactDTO contactDTO = new ContactDTO(contact);
            contactList.add(contactDTO);
        });
    }
}