package com.Certant.servicio.del.automotor.persistencia.repositories;


import com.Certant.servicio.del.automotor.logica.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TurnoRepository extends JpaRepository<Turno,Long> {
}
