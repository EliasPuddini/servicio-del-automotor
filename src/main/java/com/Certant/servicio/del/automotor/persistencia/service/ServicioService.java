package com.Certant.servicio.del.automotor.persistencia.service;

import com.Certant.servicio.del.automotor.dto.ClientDTO;
import com.Certant.servicio.del.automotor.dto.ServicioDTO;
import com.Certant.servicio.del.automotor.logica.Servicio;

import java.util.List;
import java.util.Optional;

public interface ServicioService {
    List<ServicioDTO> getServiciosDTO();

    Optional<Servicio> getServicio(Long id);
    void deleteServicio(Long id);
    void saveServicio(Servicio servicio);

}
