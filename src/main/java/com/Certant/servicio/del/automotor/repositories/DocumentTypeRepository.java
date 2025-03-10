package com.Certant.servicio.del.automotor.repositories;

import com.Certant.servicio.del.automotor.models.entities.DocumentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DocumentTypeRepository extends JpaRepository<DocumentType,Long> {
}
