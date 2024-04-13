package com.Certant.servicio.del.automotor.service;

import com.Certant.servicio.del.automotor.dto.TurnoDTO;
import com.Certant.servicio.del.automotor.models.Turno;

import java.util.List;
import java.util.Optional;

public interface TurnosService {
    List<TurnoDTO> getTurnosDTO();

    TurnoDTO getTurnoDTO(Long id);
    void saveTurno(Turno turno);

    void deleteTurno(Long id);

}
