package com.Certant.servicio.del.automotor.service;


import com.Certant.servicio.del.automotor.models.dto.ClientDTO;
import com.Certant.servicio.del.automotor.models.entities.Client;

import java.util.List;

public interface ClientService {
    public List<ClientDTO> getAll();
    public ClientDTO getByID(Long id);
    public void deleteByID(Long id);
    public void save(Client client);
    public void patch(Client client);
}
