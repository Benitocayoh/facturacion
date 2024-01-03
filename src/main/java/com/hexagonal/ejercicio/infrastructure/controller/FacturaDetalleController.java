package com.hexagonal.ejercicio.infrastructure.controller;

import com.hexagonal.ejercicio.aplication.service.FacturaCabeceraService;
import com.hexagonal.ejercicio.aplication.service.FacturaDetalleService;
import com.hexagonal.ejercicio.domain.model.FacturaCabecera;
import com.hexagonal.ejercicio.domain.model.FacturaDetalle;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("api/facturadetalle")
public class FacturaDetalleController {
    private final FacturaDetalleService facturaDetalleService;

    public FacturaDetalleController(FacturaDetalleService facturaDetalleService) {
        this.facturaDetalleService = facturaDetalleService;
    }

    @PostMapping
    public ResponseEntity<FacturaDetalle> crear (@RequestBody FacturaDetalle facturaDetalle){
        FacturaDetalle creaFacturaDetalle=facturaDetalleService.Crear(facturaDetalle);
        return new ResponseEntity<>(creaFacturaDetalle, HttpStatus.CREATED);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<FacturaDetalle> getFacturaDetalle(@PathVariable Long id){
        return facturaDetalleService.GetFacturaDetalle(id)
                .map(FacturaDetalle-> new ResponseEntity<>(FacturaDetalle,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping ("/")
    public List<FacturaDetalle> getFacturaCabeceras(){

        return facturaDetalleService.GetFacturaDetalle();
    }

    @PutMapping("/{id}")
    public ResponseEntity<FacturaDetalle> Update(@PathVariable Long id, @RequestBody FacturaDetalle facturaDetalle){
        return facturaDetalleService.Actualizar(id,facturaDetalle)
                .map(pro-> new ResponseEntity<>(pro,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Delete(@PathVariable Long id){
        if (facturaDetalleService.BorrarFacturaDetalle(id))
        {
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }else {
            return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
