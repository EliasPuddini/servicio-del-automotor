package com.Certant.servicio.del.automotor.controllers;

import com.Certant.servicio.del.automotor.models.dto.OrderDTO;
import com.Certant.servicio.del.automotor.models.dto.Person.PersonDTO;
import com.Certant.servicio.del.automotor.models.entities.Person.Person;
import com.Certant.servicio.del.automotor.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping()
    public ResponseEntity<List<PersonDTO>> getAll(){
        try{
            List<PersonDTO> personDTO = personService.getAll();
            return ResponseEntity.status(HttpStatus.OK).body(personDTO);
        } catch (Exception exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/{personID}")
    public ResponseEntity<PersonDTO> getByID(@PathVariable("personID") Long id){
        try{
            PersonDTO personDTO = personService.getById(id);
            return ResponseEntity.status(HttpStatus.OK).body(personDTO);
        } catch (Exception exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<String> savePerson(@RequestBody Person person){
        try{
            personService.save(person);
            return ResponseEntity.status(HttpStatus.OK).body("Person saved successfully");
        } catch (Exception exception){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Person not saved");
        }
    }

    @DeleteMapping("/{personID}")
    public ResponseEntity<String> deletePerson(@PathVariable("personID") Long id){
        try{
            personService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Person deleted successfully");
        } catch (Exception exception){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Person not deleted");
        }
    }

    @PutMapping("/{personID}")
    public ResponseEntity<String> putPerson(@PathVariable("personID") Long id,@RequestBody Person person){
        try{
            personService.putPerson(id,person);
            return ResponseEntity.status(HttpStatus.OK).body("Person with ID: "+ id+" updated successfully");
        } catch (Exception exception){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Error updating Person with ID: " + id);
        }
    }

}
