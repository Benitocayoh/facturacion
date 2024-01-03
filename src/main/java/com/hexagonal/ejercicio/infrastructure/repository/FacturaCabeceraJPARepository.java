package com.hexagonal.ejercicio.infrastructure.repository;

import com.hexagonal.ejercicio.infrastructure.entity.FacturaCabeceraEntity;
import com.hexagonal.ejercicio.infrastructure.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaCabeceraJPARepository extends JpaRepository<FacturaCabeceraEntity,Long> {
}
