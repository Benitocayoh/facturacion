package com.hexagonal.ejercicio.domain.ports.out;

import com.hexagonal.ejercicio.domain.model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoOut {
    Producto Crear(Producto producto);
    Optional<Producto> Actualizar (Long id, Producto producto);
    Optional<Producto> GetProducto (Long id);
    List<Producto> GetProductos ();
    Boolean borrarProducto(Long id);
}
