package com.Certant.servicio.del.automotor.models.dto;

import com.Certant.servicio.del.automotor.models.entities.Contact;
import lombok.Getter;

@Getter
public class ContactDTO {
    private String email;
    private String phone;

    public ContactDTO(Contact contact){
        this.email = contact.getEmail();
        this.phone = contact.getPhone();
    }
}
