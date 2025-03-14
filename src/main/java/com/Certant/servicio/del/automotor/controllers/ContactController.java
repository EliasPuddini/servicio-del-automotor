package com.Certant.servicio.del.automotor.controllers;


import com.Certant.servicio.del.automotor.models.dto.ContactDTO;
import com.Certant.servicio.del.automotor.models.entities.Contact;
import com.Certant.servicio.del.automotor.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/contacts")
public class ContactController {

    @Autowired
    public ContactService contactService;

    @GetMapping
    public ResponseEntity<List<ContactDTO>> getAll(){
        try{
            List<ContactDTO> contactDTOList = contactService.getAll();
            return ResponseEntity.status(HttpStatus.OK).body(contactDTOList);
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{contactID}")
    public ResponseEntity<ContactDTO> getContact(@PathVariable("contactID") Long id){
        try{
            ContactDTO contactDTO = contactService.getById(id);
            return ResponseEntity.status(HttpStatus.OK).body(contactDTO);
        } catch (Exception exception){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{contactId}")
    public ResponseEntity<String> deleteContact(@PathVariable("contactId") Long id){
        try{
            contactService.deleteContact(id);
            return ResponseEntity.status(HttpStatus.OK).body(" Se ha eliminado el contacto. ");
        } catch (Exception exception){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(" No se ha podido eliminar el contacto. ");
        }
    }

    @PostMapping
    public ResponseEntity<String> saveContact(@RequestBody Contact contact){
        try{
            contactService.saveContact(contact);
            return ResponseEntity.status(HttpStatus.OK).body(" Se ha guardado el contacto. ");
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(" No se ha podido guardar el contacto. ");
        }
    }

}
