package com.Certant.servicio.del.automotor.models.dto;

import com.Certant.servicio.del.automotor.models.entities.Client;
import com.Certant.servicio.del.automotor.models.entities.Contact;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ClientDTO {
    private String name;
    private DocumentDTO document;
    private UserDTO user;
    private ClientTypeDTO clientType;
    private List<ContactDTO> contactList = new ArrayList<>();

    public ClientDTO(Client client){
        this.name = client.getName();
        this.document = new DocumentDTO(client.getDocument());
        this.user = new UserDTO(client.getUser());
        this.clientType = new ClientTypeDTO(client.getClientType());
        client.getContatList().forEach(contact -> {
            ContactDTO contactDTO = new ContactDTO(contact);
            contactList.add(contactDTO);
        });
    }
}