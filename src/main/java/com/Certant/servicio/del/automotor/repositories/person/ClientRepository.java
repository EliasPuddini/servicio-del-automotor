package com.Certant.servicio.del.automotor.repositories.person;

import com.Certant.servicio.del.automotor.models.entities.Person.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ClientRepository extends JpaRepository<Client,Long> {
}
