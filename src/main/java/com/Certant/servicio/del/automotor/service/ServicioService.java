package com.Certant.servicio.del.automotor.service;

import com.Certant.servicio.del.automotor.dto.ServicioDTO;
import com.Certant.servicio.del.automotor.models.Servicio;
import com.Certant.servicio.del.automotor.repositories.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class ServicioService {
    @Autowired
    private ServicioRepository servicioRepository;

    public List<ServicioDTO> getServiciosDTO(){
        return servicioRepository.findAll().stream().map(servicio -> new ServicioDTO(servicio)).collect(toList());
    }

    public ServicioDTO getServicio(Long id){
        return servicioRepository.findById(id).map(ServicioDTO::new).orElse(null);
    }

    public void deleteServicio(Long id){
        servicioRepository.deleteById(id);
    }

    public void saveServicio(Servicio servicio){
        servicioRepository.save(servicio);
    }
}
