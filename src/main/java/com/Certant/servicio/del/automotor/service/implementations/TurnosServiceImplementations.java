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

        Servicio finalServicio = servicio;
        Client finalCliente = cliente;

        if(servicioRepository.findAll().stream().noneMatch(servicioN -> Objects.equals(servicioN.getLavado(), finalServicio.getLavado())
                                                        && Objects.equals(servicioN.getAceiteyfiltro(),finalServicio.getAceiteyfiltro())
                                                        && Objects.equals(servicioN.getAlineacionybalanceo(), finalServicio.getAlineacionybalanceo())
                                                        )){
            servicioRepository.save(turno.getServicio());
        }else{

            servicio = servicioRepository.findAll().stream().filter(servicioN -> Objects.equals(servicioN.getLavado(), finalServicio.getLavado())
                    && Objects.equals(servicioN.getAceiteyfiltro(), finalServicio.getAceiteyfiltro())
                    && Objects.equals(servicioN.getAlineacionybalanceo(), finalServicio.getAlineacionybalanceo())).findFirst().orElse(null);
            turno.setServicio(servicio);
        }

        if(clientRepository.findAll().stream().noneMatch(clienteN -> clienteN.getDni() == finalCliente.getDni())){
            clientRepository.save(turno.getCliente());
        }else{
            cliente = clientRepository.findAll().stream().filter(client -> client.getDni() == finalCliente.getDni()).findFirst().orElse(null);
            turno.setCliente(cliente);
        }



        turnoRepository.save(turno);
    }
    @Override
    public void deleteTurno(Long id){

        turnoRepository.deleteById(id);
    }
}
