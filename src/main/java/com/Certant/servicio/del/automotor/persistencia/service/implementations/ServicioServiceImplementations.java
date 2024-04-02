package com.Certant.servicio.del.automotor.persistencia.service.implementations;

import com.Certant.servicio.del.automotor.dto.ServicioDTO;
import com.Certant.servicio.del.automotor.logica.Servicio;
import com.Certant.servicio.del.automotor.persistencia.repositories.ServicioRepository;
import com.Certant.servicio.del.automotor.persistencia.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class ServicioServiceImplementations implements ServicioService {

    @Autowired
    private ServicioRepository servicioRepository;

    @Override
    public List<ServicioDTO> getServiciosDTO(){
        return servicioRepository.findAll().stream().map(servicio -> new ServicioDTO(servicio)).collect(toList());
    }
    @Override
    public Optional<Servicio> getServicio(Long id){
        return servicioRepository.findById(id);
    }
    @Override
    public void deleteServicio(Long id){
        servicioRepository.deleteById(id);
    }
    @Override
    public void saveServicio(Servicio servicio){
        servicioRepository.save(servicio);
    }
}
