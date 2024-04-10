package com.Certant.servicio.del.automotor.controllers;

import com.Certant.servicio.del.automotor.dto.ClientDTO;
import com.Certant.servicio.del.automotor.dto.TurnoDTO;
import com.Certant.servicio.del.automotor.models.Client;
import com.Certant.servicio.del.automotor.models.Turno;
import com.Certant.servicio.del.automotor.repositories.ClientRepository;
import com.Certant.servicio.del.automotor.service.ClientService;
import com.Certant.servicio.del.automotor.service.TurnosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/turnos")
public class TurnoController {

    @Autowired
    private TurnosService turnosService;

    @GetMapping()
    public List<TurnoDTO> getAll(){
        return turnosService.getTurnosDTO();
    }

    @GetMapping("/{turnoId}")
    public TurnoDTO  getById(@PathVariable("turnoId") Long turnoId){
        return turnosService.getTurnoDTO(turnoId);
    }

    @PostMapping
    public void saveTurno(@RequestBody Turno turno){
        turnosService.saveTurno(turno);
    }

    @DeleteMapping("/{turnoId}")
    public void delete(@PathVariable("turnoId") Long turnoId){
        turnosService.deleteTurno(turnoId);
    }
}
