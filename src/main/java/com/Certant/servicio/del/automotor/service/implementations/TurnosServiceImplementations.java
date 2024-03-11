package com.Certant.servicio.del.automotor.service.implementations;

import com.Certant.servicio.del.automotor.dto.TurnoDTO;
import com.Certant.servicio.del.automotor.models.Turno;
import com.Certant.servicio.del.automotor.repositories.ClientRepository;
import com.Certant.servicio.del.automotor.repositories.ServicioRepository;
import com.Certant.servicio.del.automotor.repositories.TurnoRepository;
import com.Certant.servicio.del.automotor.service.TurnosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TurnosServiceImplementations implements TurnosService {

    @Autowired
    TurnoRepository turnoRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    ServicioRepository servicioRepository;

    @Override
    public List<TurnoDTO> getTurnosDTO(){
        return turnoRepository.findAll().stream().map(turno ->new TurnoDTO(turno)).collect(Collectors.toList());
    }
    @Override
    public Optional<Turno> getTurnoDTO(Long id){
        return turnoRepository.findById(id);
    }
    @Override
    public void saveTurno(Turno turno){

        servicioRepository.save(turno.getServicio());
        clientRepository.save(turno.getCliente());
        turnoRepository.save(turno);
    }
    @Override
    public void deleteTurno(Long id){

        turnoRepository.deleteById(id);
    }
}
