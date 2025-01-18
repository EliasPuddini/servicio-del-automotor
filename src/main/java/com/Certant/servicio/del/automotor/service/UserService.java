package com.Certant.servicio.del.automotor.service;

import com.Certant.servicio.del.automotor.models.dto.Person.MechanicDTO;
import com.Certant.servicio.del.automotor.models.dto.Person.PersonDTO;
import com.Certant.servicio.del.automotor.models.dto.UserDTO;
import com.Certant.servicio.del.automotor.models.entities.User;

import java.util.List;

public interface UserService {
    List<UserDTO> getAll();
    UserDTO getByName(String name);
    UserDTO getById(Long id);
    void deleteUser(Long id);
    void saveUser(User user);
    void updateUser(User user);
}
