package com.Certant.servicio.del.automotor.models.dto;

import com.Certant.servicio.del.automotor.models.entities.Contact;
import lombok.Getter;

@Getter
public class ContactDTO {
    private Long id;
    private String email;
    private String phone;

    public ContactDTO(Contact contact){
        this.id = contact.getId();
        this.email = contact.getEmail();
        this.phone = contact.getPhone();
    }
}
