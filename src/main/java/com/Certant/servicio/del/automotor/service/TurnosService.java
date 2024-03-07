package com.Certant.servicio.del.automotor.service;

import com.Certant.servicio.del.automotor.dto.TurnoDTO;
import com.Certant.servicio.del.automotor.models.Turno;

import java.util.List;

public interface TurnosService {
    List<TurnoDTO> getTurnosDTO();

    Turno getTurnoDTO(Long id);
    void saveTurno(Turno turno);



}
