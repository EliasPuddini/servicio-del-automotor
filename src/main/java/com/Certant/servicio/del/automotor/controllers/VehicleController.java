package com.Certant.servicio.del.automotor.controllers;

import com.Certant.servicio.del.automotor.models.dto.VehicleDTO;
import com.Certant.servicio.del.automotor.models.entities.Vehicle;
import com.Certant.servicio.del.automotor.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping
    public ResponseEntity<List<VehicleDTO>> getAll(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(vehicleService.getVehicles());
        } catch (Exception exception){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{vehicleId}")
    public ResponseEntity<VehicleDTO> getVehicle(@PathVariable("vehicleId") Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(vehicleService.getVehicle(id));
        } catch (Exception exception){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<String> postVehicle(@RequestBody Vehicle vehicle){
        try {
            vehicleService.saveVehicle(vehicle);
            return ResponseEntity.status(HttpStatus.OK).body(" Se ha guardado el vehiculo. ");
        } catch (Exception exception){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(" No se ha guardado el vehiculo. ");
        }
    }

    @DeleteMapping("/{vehicleId}")
    public ResponseEntity<String> deleteVehicle(@PathVariable("vehicleId") Long id){
        try {
            vehicleService.deleteVehicle(id);
            return ResponseEntity.status(HttpStatus.OK).body(" Se ha eliminado el vehiculo. ");
        } catch (Exception exception){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(" No se ha podido eliminar el vehiculo. ");
        }
    }

}
