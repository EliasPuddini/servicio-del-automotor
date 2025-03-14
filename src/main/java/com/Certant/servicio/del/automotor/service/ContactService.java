package com.Certant.servicio.del.automotor.service;

import com.Certant.servicio.del.automotor.models.dto.ContactDTO;
import com.Certant.servicio.del.automotor.models.entities.Contact;

import java.util.List;

public interface ContactService {
    public List<ContactDTO> getAll();
    public ContactDTO getById(Long id);
    public void deleteContact(Long id);
    public void saveContact(Contact contact);
}
