package com.Certant.servicio.del.automotor.service.implementations;

import com.Certant.servicio.del.automotor.dto.ClientDTO;
import com.Certant.servicio.del.automotor.models.Client;
import com.Certant.servicio.del.automotor.repositories.ClientRepository;
import com.Certant.servicio.del.automotor.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class ClientServiceImplementations implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<ClientDTO> getClientsDTO() {
        return clientRepository.findAll().stream().map(client ->new ClientDTO(client)).collect(toList());
    }

    @Override
    public ClientDTO getClient(Long id){
        return clientRepository.findById(id).map(ClientDTO ::new).orElse(null);
    };

    @Override
    public void saveClient(Client newClient){
        clientRepository.save(newClient);
    }

    @Override
    public void deleteClient(Long id){
        clientRepository.deleteById(id);
    }

    @Override
    public void updateServicecounter(Long id){
        Client client = clientRepository.findById(id).orElse(null);
        clientRepository.deleteById(client.getId());
        client.updateServicecounter();
        clientRepository.save(client);
    }

}
