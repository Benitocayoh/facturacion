package com.hexagonal.ejercicio.infrastructure.controller;

import com.hexagonal.ejercicio.aplication.service.ProductoService;
import com.hexagonal.ejercicio.domain.model.Producto;
import com.hexagonal.ejercicio.domain.model.persona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("api/productos")
public class ProductoController {
    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping
    public ResponseEntity<Producto> crear (@RequestBody Producto producto){
        Producto creaProducto=productoService.Crear(producto);
        return new ResponseEntity<>(creaProducto, HttpStatus.CREATED);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<Producto> getProducto(@PathVariable Long id){
        return productoService.GetProducto(id)
                .map(Producto-> new ResponseEntity<>(Producto,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping ("/")
    public List<Producto> getProductos(){
        return productoService.GetProductos();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> UpdateProducto(@PathVariable Long id, @RequestBody Producto producto){
        return productoService.Actualizar(id,producto)
                .map(pro-> new ResponseEntity<>(pro,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> DeleteProducto(@PathVariable Long id){
        if (productoService.borrarProducto(id))
        {
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }else {
            return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
