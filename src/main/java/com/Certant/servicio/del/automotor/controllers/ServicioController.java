package com.Certant.servicio.del.automotor.controllers;

import com.Certant.servicio.del.automotor.dto.ServicioDTO;
import com.Certant.servicio.del.automotor.models.Servicio;
import com.Certant.servicio.del.automotor.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/servicios")
public class ServicioController {

    @Autowired
    ServicioService servicioService;

    @GetMapping()
    public List<ServicioDTO> getAll(){
        return servicioService.getServiciosDTO();
    }

    @GetMapping("/{servicioId}")
    public Optional<Servicio> getById(@PathVariable("servicioId") Long servicioId){
        return servicioService.getServicio(servicioId);
    }

    @PostMapping
    public void saveServicioPorId(@RequestBody Servicio servicio){
        servicioService.saveServicio(servicio);
    }

    @DeleteMapping("/{servicioId}")
    public void delete(@PathVariable("servicioId") Long servicioId){
        servicioService.deleteServicio(servicioId);
    }

}
