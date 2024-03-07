package com.Certant.servicio.del.automotor.service;

import com.Certant.servicio.del.automotor.dto.ClientDTO;
import com.Certant.servicio.del.automotor.models.Client;

import java.util.List;
import java.util.Optional;


public interface ClientService {
    List<ClientDTO> getClientsDTO();

    Optional<Client> getClient(Long id);
    void deleteClient(Long id);
    void saveClient(Client client);
    void updateServicecounter(Long id);
}
