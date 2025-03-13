package com.Certant.servicio.del.automotor.controllers;

import com.Certant.servicio.del.automotor.models.dto.VehicleDTO;
import com.Certant.servicio.del.automotor.models.dto.VehicleTypeDTO;
import com.Certant.servicio.del.automotor.models.entities.VehicleType;
import com.Certant.servicio.del.automotor.service.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/vehicleTypes")
public class VehicleTypeController {

    @Autowired
    private VehicleTypeService vehicleTypeService;

    @GetMapping
    public ResponseEntity<List<VehicleTypeDTO>> getAll(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(vehicleTypeService.getAll());
        } catch (Exception exception){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }

    @GetMapping("/{vehicleTypeID}")
    public ResponseEntity<VehicleTypeDTO> getVehicleType(@PathVariable("vehicleTypeID") Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(vehicleTypeService.getByID(id));
        } catch (Exception exception){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }

    @DeleteMapping
    public ResponseEntity<String> deleteVehicleType(@RequestBody Long id){
        try {
            vehicleTypeService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body(" Se ha eliminado el tipo de vehiculo. ");
        } catch(Exception exception) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(" No se ha podido eliminar el tipo de vehiculo. ");
        }
    }

    @PostMapping
    public ResponseEntity<String> postVehicleType(@RequestBody VehicleType vehicleType){
        try {
            vehicleTypeService.save(vehicleType);
            return ResponseEntity.status(HttpStatus.OK).body(" Se ha eliminado el tipo de vehiculo");
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(" No se ha podido guardar el tipo de vehiculo. ");
        }
    }

}
