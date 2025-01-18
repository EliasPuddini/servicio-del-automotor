package com.Certant.servicio.del.automotor.controllers;

import com.Certant.servicio.del.automotor.models.entities.Person.Person;
import com.Certant.servicio.del.automotor.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping()
    public void getAll(){
        personService.getAll();
    }

    @GetMapping("/{personID}")
    public ResponseEntity<String> getByID(@PathVariable("personID") Long id){
        try{
            personService.getById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Person found successfully");
        } catch (Exception exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Person not found");
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
