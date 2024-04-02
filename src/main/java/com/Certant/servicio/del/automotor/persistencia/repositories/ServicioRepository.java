package com.Certant.servicio.del.automotor.persistencia.repositories;

import com.Certant.servicio.del.automotor.logica.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ServicioRepository extends JpaRepository<Servicio,Long> {
}
