package com.Certant.servicio.del.automotor.controllers;

import com.Certant.servicio.del.automotor.dto.ClientDTO;
import com.Certant.servicio.del.automotor.models.Client;
import com.Certant.servicio.del.automotor.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.Certant.servicio.del.automotor.service.ClientService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/clients")
public class ClientController {

    @Autowired
    private ClientRepository clienteRepository;
    @Autowired
    private ClientService clientService;

    @GetMapping()
    public List<ClientDTO> getAll(){
        return clientService.getClientsDTO();
    }

    @GetMapping("/{clientId}")
    public ClientDTO getById(@PathVariable("clientId") Long clientId){
        return clientService.getClient(clientId);
    }

    @PostMapping
    public void saveClient(@RequestBody Client client){
        clientService.saveClient(client);
    }

    @DeleteMapping("/{clientId}")
    public void delete(@PathVariable("clientId") Long clientId){
        clientService.deleteClient(clientId);
    }
}
