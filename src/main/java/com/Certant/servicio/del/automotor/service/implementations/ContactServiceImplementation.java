package com.Certant.servicio.del.automotor.service.implementations;

import com.Certant.servicio.del.automotor.models.dto.ContactDTO;
import com.Certant.servicio.del.automotor.models.entities.Client;
import com.Certant.servicio.del.automotor.models.entities.Contact;
import com.Certant.servicio.del.automotor.models.entities.Mechanic;
import com.Certant.servicio.del.automotor.repositories.ClientRepository;
import com.Certant.servicio.del.automotor.repositories.ContactRepository;
import com.Certant.servicio.del.automotor.repositories.MechanicRepository;
import com.Certant.servicio.del.automotor.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ContactServiceImplementation implements ContactService {

    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private MechanicRepository mechanicRepository;

    @Override
    public List<ContactDTO> getAll() {

        List<ContactDTO> contactDTOList = new ArrayList<>();
        contactRepository.findAll().forEach(contact -> {
            contactDTOList.add(new ContactDTO(contact));
        });

        return contactDTOList;
    }

    @Override
    public ContactDTO getById(Long id) {
        return new ContactDTO(Objects.requireNonNull(contactRepository.findById(id).orElse(null)));
    }

    @Override
    public void deleteContact(Long id) {

        Contact contact = contactRepository.findById(id).orElse(null);

        if(contact != null){
            Client client = clientRepository.findAll().stream().filter(client1 -> client1.getContacts().contains(contact)).findFirst().orElse(null);
            Mechanic mechanic = mechanicRepository.findAll().stream().filter(mechanic1 -> mechanic1.getContactList().contains(contact)).findFirst().orElse(null);
            if(client != null){
                client.getContacts().remove(contact);
                clientRepository.save(client);
            }
            if(mechanic != null){
                mechanic.getContactList().remove(contact);
                mechanicRepository.save(mechanic);
            }

        }
        contactRepository.deleteById(id);

    }

    @Override
    public void saveContact(Contact contact) {
        contactRepository.save(contact);
    }
}
