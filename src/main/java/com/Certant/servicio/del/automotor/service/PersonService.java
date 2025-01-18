package com.Certant.servicio.del.automotor.service;


import com.Certant.servicio.del.automotor.models.dto.Person.ClientDTO;
import com.Certant.servicio.del.automotor.models.dto.Person.MechanicDTO;
import com.Certant.servicio.del.automotor.models.dto.Person.PersonDTO;
import com.Certant.servicio.del.automotor.models.entities.Person.Person;

import java.util.List;

public interface PersonService {
    List<PersonDTO> getAll();
    List<ClientDTO> getClients();
    PersonDTO getById(Long id);
    void deleteById(Long id);
    void save(Person person);
    List<MechanicDTO> getMechanics();
    List<PersonDTO> getAdmins();
    void putPerson(Long id,Person person);
}
