package com.Certant.servicio.del.automotor.repositories;

import com.Certant.servicio.del.automotor.models.entities.Person.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
