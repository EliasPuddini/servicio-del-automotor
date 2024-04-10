package com.Certant.servicio.del.automotor.service.implementations;

import com.Certant.servicio.del.automotor.dto.TurnoDTO;
import com.Certant.servicio.del.automotor.models.Client;
import com.Certant.servicio.del.automotor.models.Servicio;
import com.Certant.servicio.del.automotor.models.Turno;
import com.Certant.servicio.del.automotor.repositories.ClientRepository;
import com.Certant.servicio.del.automotor.repositories.ServicioRepository;
import com.Certant.servicio.del.automotor.repositories.TurnoRepository;
import com.Certant.servicio.del.automotor.service.TurnosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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
    public TurnoDTO getTurnoDTO(Long id){
        return turnoRepository.findById(id).map(TurnoDTO::new).orElse(null);
    }
    @Override
    public void saveTurno(Turno turno){

        Servicio servicio = turno.getServicio();
        Client cliente = turno.getCliente();
        cliente.updateServicecounter();

        if(servicioRepository.findAll().stream().noneMatch(servicioN -> Objects.equals(servicioN.getLavado(), servicio.getLavado())
                                                        && Objects.equals(servicioN.getAceiteyfiltro(),servicio.getAceiteyfiltro())
                                                        && Objects.equals(servicioN.getAlineacionybalanceo(), servicio.getAlineacionybalanceo())
                                                        )){
            servicioRepository.save(turno.getServicio());
        }
        if(clientRepository.findAll().stream().noneMatch(clienteN -> clienteN.getDni() == cliente.getDni())){
            clientRepository.save(turno.getCliente());
        }

        turnoRepository.save(turno);
    }
    @Override
    public void deleteTurno(Long id){

        turnoRepository.deleteById(id);
    }
}
