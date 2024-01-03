package com.hexagonal.ejercicio.infrastructure.controller;

import com.hexagonal.ejercicio.aplication.service.FacturaCabeceraService;
import com.hexagonal.ejercicio.domain.model.FacturaCabecera;
import com.hexagonal.ejercicio.domain.model.Producto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("api/facturacabecera")
public class FacturaCabeceraController {
    private final FacturaCabeceraService facturaCabeceraService;

    public FacturaCabeceraController(FacturaCabeceraService facturaCabeceraService) {
        this.facturaCabeceraService = facturaCabeceraService;
    }


    @PostMapping
    public ResponseEntity<FacturaCabecera> crear (@RequestBody FacturaCabecera facturaCabecera){
        FacturaCabecera creaFacturaCabecera=facturaCabeceraService.Crear(facturaCabecera);
        return new ResponseEntity<>(creaFacturaCabecera, HttpStatus.CREATED);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<FacturaCabecera> getFacturaCabecera(@PathVariable Long id){
        return facturaCabeceraService.GetFacturaCabecera(id)
                .map(FacturaCabecera-> new ResponseEntity<>(FacturaCabecera,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping ("/")
    public List<FacturaCabecera> getFacturaCabeceras(){
        return facturaCabeceraService.GetFacturaCabeceras();
    }

    @PutMapping("/{id}")
    public ResponseEntity<FacturaCabecera> Update(@PathVariable Long id, @RequestBody FacturaCabecera facturaCabecera){
        return facturaCabeceraService.Actualizar(id,facturaCabecera)
                .map(pro-> new ResponseEntity<>(pro,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> DeleteProducto(@PathVariable Long id){
        if (facturaCabeceraService.BorrarFacturaCabecera(id))
        {
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }else {
            return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
