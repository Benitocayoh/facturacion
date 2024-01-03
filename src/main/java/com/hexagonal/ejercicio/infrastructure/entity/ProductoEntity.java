package com.hexagonal.ejercicio.infrastructure.entity;

import com.hexagonal.ejercicio.domain.model.Producto;
import com.hexagonal.ejercicio.domain.model.persona;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table (name = "Productos")
public class ProductoEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long producto_id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private long Stock;

    public ProductoEntity() {
    }

    public ProductoEntity(long producto_id, String nombre, String descripcion, Double precio, long stock) {
        this.producto_id = producto_id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.Stock = stock;
    }

    public static ProductoEntity fromDomainModel(Producto producto){
        return new ProductoEntity(producto.getProducto_id(),producto.getNombre(),producto.getDescripcion(),producto.getPrecio(), producto.getStock());
    }

    public Producto toDomainModel(){
        return new Producto(producto_id,nombre,descripcion,precio,Stock);
    }

}
