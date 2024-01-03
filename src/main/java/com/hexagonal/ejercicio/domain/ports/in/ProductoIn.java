package com.hexagonal.ejercicio.domain.ports.in;

import com.hexagonal.ejercicio.domain.model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoIn {
    Producto Crear(Producto producto);
    Optional<Producto> Actualizar (Long id, Producto producto);
    Optional<Producto> GetProducto (Long id);
    List<Producto> GetProductos ();
    Boolean borrarProducto(Long id);
}
