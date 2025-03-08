package com.Certant.servicio.del.automotor.controllers;

import com.Certant.servicio.del.automotor.models.dto.ServiceDTO;
import com.Certant.servicio.del.automotor.models.entities.Service;
import com.Certant.servicio.del.automotor.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @GetMapping
    public ResponseEntity<List<ServiceDTO>> getAll(){
        try{
            List<ServiceDTO> serviceDTOS = serviceService.getServices();
            return ResponseEntity.status(HttpStatus.OK).body(serviceDTOS);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }

    @GetMapping("/{serviceId}")
    public ResponseEntity<ServiceDTO> getService(@PathVariable("serviceId")Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(serviceService.getServiceByID(id));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }

    @DeleteMapping
    public ResponseEntity<String> deleteService(@RequestBody Long id){
        try{
            serviceService.deleteService(id);
            return ResponseEntity.status(HttpStatus.OK).body(" Se ha eliminado el servicio con id: " + id);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(" No se pudo eliminar el servicio. ");
        }
    }

    @PostMapping
    public ResponseEntity<String> postService(@RequestBody Service service){
        try {
            serviceService.saveService(service);
            return ResponseEntity.status(HttpStatus.OK).body(" Se ha guardado el servicio. ");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(" No se ha podido guardar el servicio. ");
        }
    }


}
