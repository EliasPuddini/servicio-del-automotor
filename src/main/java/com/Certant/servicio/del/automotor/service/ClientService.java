package com.Certant.servicio.del.automotor.service;

import com.Certant.servicio.del.automotor.dto.ClientDTO;
import com.Certant.servicio.del.automotor.models.Client;
import com.Certant.servicio.del.automotor.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<ClientDTO> getClientsDTO() {
        return clientRepository.findAll().stream().map(client ->new ClientDTO(client)).collect(toList());
    }

    public ClientDTO getClient(Long id){
        return clientRepository.findById(id).map(ClientDTO::new).orElse(null);
    }

    public void saveClient(Client newClient){
        clientRepository.save(newClient);
    }

    public void deleteClient(Long id){
        clientRepository.deleteById(id);
    }

    public void updateServicecounter(Long id){
        Client client = clientRepository.findById(id).orElse(null);
        clientRepository.deleteById(client.getId());
        client.updateServicecounter();
        clientRepository.save(client);
    }
}
