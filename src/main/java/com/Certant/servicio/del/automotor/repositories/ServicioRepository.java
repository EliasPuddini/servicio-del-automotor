package com.Certant.servicio.del.automotor.repositories;

import com.Certant.servicio.del.automotor.models.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource
public interface ServicioRepository extends JpaRepository<Servicio,Long> {
}
