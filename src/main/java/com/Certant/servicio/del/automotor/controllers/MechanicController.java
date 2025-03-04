package com.Certant.servicio.del.automotor.controllers;

import com.Certant.servicio.del.automotor.models.dto.MechanicDTO;
import com.Certant.servicio.del.automotor.models.entities.Mechanic;
import com.Certant.servicio.del.automotor.service.MechanicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/mechanics")
public class MechanicController {

    @Autowired
    private MechanicService mechanicService;

    @GetMapping()
    public ResponseEntity<List<MechanicDTO>> getAll(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(mechanicService.getAll());
        } catch (Exception exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/{mechanicID}")
    public ResponseEntity<MechanicDTO> getMechanic(@PathVariable("mechanicID") Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(mechanicService.getByID(id));
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("{mechanicID}")
    public ResponseEntity<String> deleteMechanic(@PathVariable("mechanicID")Long id){
        try{
            mechanicService.DeleteByID(id);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }

    @PostMapping()
    public ResponseEntity<String> postMechanic(@RequestBody Mechanic mechanic){
        try{
            mechanicService.save(mechanic);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }
}
