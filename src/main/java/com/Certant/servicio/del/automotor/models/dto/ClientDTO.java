package com.Certant.servicio.del.automotor.models.dto;

import com.Certant.servicio.del.automotor.models.dto.*;
import com.Certant.servicio.del.automotor.models.entities.Client;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ClientDTO{
    private Long id;
    private String name;
    private DocumentDTO document;
    private ClientTypeDTO clientType;
    private List<ContactDTO> contacts = new ArrayList<>();
    private List<VehicleDTO> vehicles = new ArrayList<>();


    public ClientDTO(Client client){
        this.id = client.getId();
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