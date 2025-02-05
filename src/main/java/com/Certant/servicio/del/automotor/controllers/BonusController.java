package com.Certant.servicio.del.automotor.controllers;


import com.Certant.servicio.del.automotor.models.dto.BonusDTO;
import com.Certant.servicio.del.automotor.models.entities.Bonus;
import com.Certant.servicio.del.automotor.service.BonusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/bonus")
public class BonusController {

    @Autowired
    private BonusService bonusService;

    @GetMapping
    public ResponseEntity<List<BonusDTO>> getAll(){
        try {
            List<BonusDTO> bonuses = bonusService.getAll();
            return ResponseEntity.status(HttpStatus.OK).body(bonuses);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/{bonusID}")
    public ResponseEntity<BonusDTO> getByID(@PathVariable("bonusID") Long bonusID){
        try {
            BonusDTO bonus = bonusService.getByID(bonusID);
            if (bonus != null) {
                return ResponseEntity.status(HttpStatus.OK).body(bonus);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
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
