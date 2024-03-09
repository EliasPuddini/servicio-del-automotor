package com.Certant.servicio.del.automotor.service.implementations;

import com.Certant.servicio.del.automotor.dto.ServicioDTO;
import com.Certant.servicio.del.automotor.models.Client;
import com.Certant.servicio.del.automotor.models.Servicio;
import com.Certant.servicio.del.automotor.repositories.ServicioRepository;
import com.Certant.servicio.del.automotor.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public Servicio getServicio(Long id){
        return servicioRepository.findById(id).orElse(null);
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
