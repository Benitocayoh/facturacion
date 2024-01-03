package com.hexagonal.ejercicio.aplication.service;

import com.hexagonal.ejercicio.domain.model.Producto;
import com.hexagonal.ejercicio.domain.ports.in.ProductoIn;

import java.util.List;
import java.util.Optional;

public class ProductoService implements ProductoIn {


    private final ProductoIn productoIn;

    public ProductoService(ProductoIn productoIn) {
        this.productoIn = productoIn;
    }

    @Override
    public Producto Crear(Producto producto) {
        return productoIn.Crear(producto);
    }

    @Override
    public Optional<Producto> Actualizar(Long id, Producto producto) {

        return productoIn.Actualizar(id,producto);
    }

    @Override
    public Optional<Producto> GetProducto(Long id) {

        return productoIn.GetProducto(id);
    }

    @Override
    public List<Producto> GetProductos() {

       return productoIn.GetProductos();
    }

    @Override
    public Boolean borrarProducto(Long id) {

        return productoIn.borrarProducto(id);
    }
}
