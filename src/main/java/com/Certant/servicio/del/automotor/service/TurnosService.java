package com.Certant.servicio.del.automotor.service;

import com.Certant.servicio.del.automotor.dto.TurnoDTO;
import com.Certant.servicio.del.automotor.models.Turno;
import com.Certant.servicio.del.automotor.repositories.ClientRepository;
import com.Certant.servicio.del.automotor.repositories.ServicioRepository;
import com.Certant.servicio.del.automotor.repositories.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TurnosService {
    @Autowired
    TurnoRepository turnoRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    ServicioRepository servicioRepository;


    public List<TurnoDTO> getTurnosDTO(){
        return turnoRepository.findAll().stream().map(turno ->new TurnoDTO(turno)).collect(Collectors.toList());
    }

    public TurnoDTO getTurnoDTO(Long id){
        return turnoRepository.findById(id).map(TurnoDTO::new).orElse(null);
    }

    public void saveTurno(Turno turno){

        servicioRepository.save(turno.getServicio());
        clientRepository.save(turno.getCliente());
        turnoRepository.save(turno);
    }

    public void deleteTurno(Long id){

        turnoRepository.deleteById(id);
    }
}
