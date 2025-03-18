package com.Certant.servicio.del.automotor.service.implementations;

import com.Certant.servicio.del.automotor.models.dto.ClientDTO;
import com.Certant.servicio.del.automotor.models.entities.*;
import com.Certant.servicio.del.automotor.repositories.*;
import com.Certant.servicio.del.automotor.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ClientServiceImplementation implements ClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private DocumentRepository documentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ClientTypeRepository clientTypeRepository;
    @Autowired
    private DocumentTypeRepository documentTypeRepository;
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;

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
            DocumentType documentType = documentTypeRepository.findAll().stream().filter(documentType1 -> documentType1.name.equals(client.getDocument().getDocumentType().getName())).findFirst().orElse(null);
            if(documentType != null) client.getDocument().setDocumentType(documentType);
            documentRepository.save(client.getDocument());
            userRepository.save(client.getUser());
            ClientType clientType = clientTypeRepository.findAll().stream().filter(Type -> Objects.equals(Type.getName(), "Basico")).findFirst().orElse(null);
            client.setClientType(clientType);
            clientRepository.save(client);
        }catch(Exception e){
            documentRepository.delete(client.getDocument());
            userRepository.delete(client.getUser());
        }

    }

    @Override
    public void patch(Client client) {
        Optional<Client> existingClientOpt = clientRepository.findById(client.getId());

        if (existingClientOpt.isPresent()) {
            Client existingClient = existingClientOpt.get();

            if (client.getContacts() != null) {
                List<Contact> updatedContacts = new ArrayList<>(existingClient.getContacts());
                for (Contact contact : client.getContacts()) {
                    if (contact.getId() == null) {
                        contactRepository.save(contact);
                        updatedContacts.add(contact);
                    }
                }
                existingClient.setContacts(updatedContacts);
            }

            if (client.getVehicles() != null) {
                List<Vehicle> updatedVehicles = new ArrayList<>(existingClient.getVehicles());
                List<VehicleType> vehicleTypes = vehicleTypeRepository.findAll().stream().toList();

                for (Vehicle vehicle : client.getVehicles()) {
                    if (vehicle.getId() == null) {

                        vehicleTypes.forEach(vehicleType -> {
                            if(Objects.equals(vehicleType.getName(), vehicle.getVehicleType().getName())){
                                vehicle.setVehicleType(vehicleType);
                            }
                        });
                        vehicleRepository.save(vehicle);
                        updatedVehicles.add(vehicle);
                    }
                }
                existingClient.setVehicles(updatedVehicles);
            }

            clientRepository.save(existingClient);
        } else {
            throw new IllegalArgumentException("Client with ID " + client.getId() + " not found");
        }
    }


}
