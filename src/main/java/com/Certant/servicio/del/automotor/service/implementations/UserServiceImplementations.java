package com.Certant.servicio.del.automotor.service.implementations;

import com.Certant.servicio.del.automotor.models.dto.UserDTO;
import com.Certant.servicio.del.automotor.models.entities.User;
import com.Certant.servicio.del.automotor.repositories.UserRepository;
import com.Certant.servicio.del.automotor.repositories.PersonRepository;
import com.Certant.servicio.del.automotor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImplementations implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<UserDTO> getAll() {

        List<UserDTO> userDTOs = new ArrayList<>();
        userRepository.findAll().forEach(user -> userDTOs.add(new UserDTO(user)));
        return userDTOs;
    }

    @Override
    public UserDTO getByName(String name) {

        return userRepository.findAll().stream().filter(user -> Objects.equals(user.getUserName(), name)).findFirst().map(UserDTO::new).orElse(null);
    }
    @Override
    public UserDTO getById(Long id){

        return userRepository.findAll().stream().filter(user -> Objects.equals(user.getId(), id)).findFirst().map(UserDTO::new).orElse(null);
    }

    @Override
    public void deleteUser(Long id) {

        User user = userRepository.findAll().stream().filter(user1 -> Objects.equals(user1.getId(), id)).findFirst().orElse(null);
        assert user != null;
        userRepository.deleteById(user.getId());
    }

    @Override
    public void saveUser(User user) {

        userRepository.save(user);
    }

    @Override
    public void updateUser(User user) {
        User existingUser = userRepository.findById(user.getId()).orElse(null);
        assert existingUser != null;
        existingUser.setUserName(user.getUserName());
        existingUser.setPassword(user.getPassword());
        existingUser.setIsAdmin(user.getIsAdmin());
        existingUser.setIsMechanic(user.getIsMechanic());
        userRepository.save(existingUser);
    }
}
