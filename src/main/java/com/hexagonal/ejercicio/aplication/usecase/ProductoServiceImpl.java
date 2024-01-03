package com.hexagonal.ejercicio.aplication.usecase;

import com.hexagonal.ejercicio.domain.model.Producto;
import com.hexagonal.ejercicio.domain.ports.in.ProductoIn;
import com.hexagonal.ejercicio.domain.ports.out.ProductoOut;

import java.util.List;
import java.util.Optional;

public class ProductoServiceImpl implements ProductoIn {

    private final ProductoOut productoOut;

    public ProductoServiceImpl(ProductoOut productoOut) {
        this.productoOut = productoOut;
    }


    @Override
    public Producto Crear(Producto producto) {
        return productoOut.Crear(producto);
    }

    @Override
    public Optional<Producto> Actualizar(Long id, Producto producto) {
        return productoOut.Actualizar(id, producto);
    }

    @Override
    public Optional<Producto> GetProducto(Long id) {
        return productoOut.GetProducto(id);
    }

    @Override
    public List<Producto> GetProductos() {
        return productoOut.GetProductos();
    }

    @Override
    public Boolean borrarProducto(Long id) {
        return productoOut.borrarProducto(id);
    }
}
