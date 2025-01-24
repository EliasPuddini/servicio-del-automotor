package com.Certant.servicio.del.automotor.controllers;


import com.Certant.servicio.del.automotor.models.entities.Bonus;
import com.Certant.servicio.del.automotor.service.BonusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/bonus")
public class BonusController {

    @Autowired
    private BonusService bonusService;

    @GetMapping
    public ResponseEntity<String> getAll(){
        try{
            bonusService.getAll();
            return ResponseEntity.status(HttpStatus.OK).body("Bonus found successfully");
        }catch(Exception ignored){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bonus not found");
        }
    }

    @GetMapping("/{bonusID}")
    public ResponseEntity<String> getByID(@PathVariable("bonusID") Long bonusID){
        try{
            bonusService.getByID(bonusID);
            return ResponseEntity.status(HttpStatus.OK).body("Bonus found successfully");
        }catch(Exception ignored){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bonus not found");
        }
    }

    @PostMapping
    public ResponseEntity<String> saveBonus(@RequestBody Bonus bonus){
        try{
            bonusService.save(bonus);
            return ResponseEntity.status(HttpStatus.OK).body("Bonus found successfully");
        }catch(Exception ignored){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bonus not found");
        }
    }

    @DeleteMapping("/{bonusID}")
    public ResponseEntity<String> deleteBonus(@PathVariable("bonusID") Long id){
        try{
            bonusService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("Bonus found successfully");
        }catch(Exception ignored){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bonus not found");
        }
    }

    @PutMapping("/{bonusID}")
    public ResponseEntity<String> updateBonus(@PathVariable("bonusID") Long id, @RequestBody @Validated Bonus bonus){
        try{
            bonusService.updateBonus(id, bonus);
            return ResponseEntity.status(HttpStatus.OK).body("Bonus found successfully");
        }catch(Exception ignored){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bonus not found");
        }
    }

}
