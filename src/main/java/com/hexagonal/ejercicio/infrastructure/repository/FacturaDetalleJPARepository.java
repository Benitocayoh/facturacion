package com.hexagonal.ejercicio.infrastructure.repository;

import com.hexagonal.ejercicio.infrastructure.entity.FacturaCabeceraEntity;
import com.hexagonal.ejercicio.infrastructure.entity.FacturaDetalleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaDetalleJPARepository extends JpaRepository<FacturaDetalleEntity,Long> {
}
