package com.Certant.servicio.del.automotor.service.implementations;

import com.Certant.servicio.del.automotor.models.dto.Person.ClientDTO;
import com.Certant.servicio.del.automotor.models.dto.Person.MechanicDTO;
import com.Certant.servicio.del.automotor.models.dto.Person.PersonDTO;
import com.Certant.servicio.del.automotor.models.entities.Person.Client;
import com.Certant.servicio.del.automotor.models.entities.Person.Mechanic;
import com.Certant.servicio.del.automotor.models.entities.Person.Person;
import com.Certant.servicio.del.automotor.repositories.PersonRepository;
import com.Certant.servicio.del.automotor.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class PersonServiceImplementation implements PersonService {
    @Autowired
    private PersonRepository personRepository;
    @Override
    public List<PersonDTO> getAll() {
        List<PersonDTO> personDTOS = new ArrayList<>();
        personRepository.findAll().forEach(person -> personDTOS.add(new PersonDTO(person)));
        return personDTOS;
    }

    @Override
    public List<ClientDTO> getClients(){
        List<ClientDTO> clientDTOS = new ArrayList<>();
        personRepository.findAll().stream().filter(person -> person.getUser().getIsMechanic()&&person.getUser().getIsAdmin()).toList()
                .forEach(client ->clientDTOS.add(new ClientDTO((Client) client)));
        return clientDTOS;
    }
    @Override
    public List<MechanicDTO> getMechanics() {

        List<MechanicDTO> mechanicDTOS = new ArrayList<>();
        personRepository.findAll().stream().filter(person -> person.getUser().getIsMechanic()).toList()
                .forEach(mechanic ->mechanicDTOS.add(new MechanicDTO((Mechanic) mechanic)));
        return mechanicDTOS;
    }

    @Override
    public PersonDTO getById(Long id) {
        return personRepository.findAll().stream().filter(person -> Objects.equals(person.getId(), id)).findFirst().map(PersonDTO::new).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public void save(Person person) {
        personRepository.save(person);
    }

    @Override
    public List<PersonDTO> getAdmins() {

        List<PersonDTO> admins = new ArrayList<>();
        personRepository.findAll().stream().filter(person -> person.getUser().getIsAdmin()).toList()
                .forEach(person -> admins.add(new PersonDTO(person)));
        return admins;
    }
}
