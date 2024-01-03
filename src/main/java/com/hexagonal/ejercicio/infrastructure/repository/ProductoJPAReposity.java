package com.hexagonal.ejercicio.infrastructure.repository;

import com.hexagonal.ejercicio.domain.model.Producto;
import com.hexagonal.ejercicio.infrastructure.entity.PersonaEntity;
import com.hexagonal.ejercicio.infrastructure.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoJPAReposity extends JpaRepository<ProductoEntity,Long> {

}
