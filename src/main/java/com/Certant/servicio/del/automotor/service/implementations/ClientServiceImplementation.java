package com.Certant.servicio.del.automotor.service.implementations;

import com.Certant.servicio.del.automotor.models.dto.ClientDTO;
import com.Certant.servicio.del.automotor.models.entities.Client;
import com.Certant.servicio.del.automotor.repositories.ClientRepository;
import com.Certant.servicio.del.automotor.repositories.DocumentRepository;
import com.Certant.servicio.del.automotor.repositories.UserRepository;
import com.Certant.servicio.del.automotor.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ClientServiceImplementation implements ClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private DocumentRepository documentRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<ClientDTO> getAll() {
        List<ClientDTO> clients = new ArrayList<>();

        clientRepository.findAll().forEach(client -> {
            clients.add(new ClientDTO(client));
        });
        return clients;
    }

    @Override
    public ClientDTO getByID(Long id) {
        return new ClientDTO(Objects.requireNonNull(clientRepository.findById(id).orElse(null)));
    }

    @Override
    public void deleteByID(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public void save(Client client) {
        try{
            documentRepository.save(client.getDocument());
            userRepository.save(client.getUser());
            clientRepository.save(client);

        }catch(Exception e){
            documentRepository.delete(client.getDocument());
            userRepository.delete(client.getUser());
        }

    }
}
