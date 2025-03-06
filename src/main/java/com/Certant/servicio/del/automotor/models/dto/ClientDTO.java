package com.Certant.servicio.del.automotor.models.dto;

import com.Certant.servicio.del.automotor.models.dto.*;
import com.Certant.servicio.del.automotor.models.entities.Client;
import lombok.Getter;

import java.util.List;

@Getter
public class ClientDTO{

    private String name;
    private DocumentDTO document;
    private ClientTypeDTO clientType;
    private List<ContactDTO> contacts;
    private List<VehicleDTO> vehicles;


    public ClientDTO(Client client){
        this.name = client.getName();
        this.document = new DocumentDTO(client.getDocument());
        this.clientType = new ClientTypeDTO(client.getClientType());

        client.getContacts().forEach(contact -> {
            ContactDTO contactDTO = new ContactDTO(contact);
            contacts.add(contactDTO);
        });
        client.getVehicles().forEach(vehicle -> {
            VehicleDTO vehicleN = new VehicleDTO(vehicle);
            vehicles.add(vehicleN);
        });
    }
}