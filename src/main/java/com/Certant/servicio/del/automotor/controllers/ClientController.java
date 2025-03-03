package com.Certant.servicio.del.automotor.controllers;

import com.Certant.servicio.del.automotor.models.dto.ClientDTO;
import com.Certant.servicio.del.automotor.models.entities.Client;
import com.Certant.servicio.del.automotor.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<List<ClientDTO>> getAll(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(clientService.getAll());
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }

    @GetMapping("{clientID}")
    public ResponseEntity<ClientDTO> getClient(@PathVariable("clientID") Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(clientService.getByID(id));
        } catch (Exception exception){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }

    @DeleteMapping("{clientID}")
    public ResponseEntity<String> deleteClient(@PathVariable("clientID") Long id){
        try{
            clientService.deleteByID(id);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } catch (Exception exception){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }

    @PostMapping()
    public ResponseEntity<String> postClient(@RequestBody Client client){
        try{
            clientService.save(client);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } catch (Exception exception){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }


}
