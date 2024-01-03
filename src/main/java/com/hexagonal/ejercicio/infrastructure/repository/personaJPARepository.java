package com.hexagonal.ejercicio.infrastructure.repository;

import com.hexagonal.ejercicio.infrastructure.entity.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface personaJPARepository extends JpaRepository<PersonaEntity,Long> {
}
