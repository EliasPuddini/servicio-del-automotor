package com.Certant.servicio.del.automotor.models.dto;

import com.Certant.servicio.del.automotor.models.entities.User;
import lombok.Getter;

@Getter
public class UserDTO {
    private String name;
    private String password;
    private Boolean isAdmin;
    private Boolean isMechanic;

    public UserDTO(User user){
        this.name = user.getUserName();
        this.password = user.getPassword();
        this.isAdmin = user.getIsAdmin();
        this.isMechanic = user.getIsMechanic();
    }
}