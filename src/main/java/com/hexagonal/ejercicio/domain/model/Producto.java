package com.hexagonal.ejercicio.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Producto {
    private long producto_id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private long Stock;

    public Producto(long id, String nombre, String descripcion, Double precio, Long stock) {
        this.producto_id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio= precio;
        this.Stock = stock;
    }
}
