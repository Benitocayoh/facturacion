package com.hexagonal.ejercicio.aplication.service;

import com.hexagonal.ejercicio.domain.model.FacturaCabecera;
import com.hexagonal.ejercicio.domain.ports.in.FacturaCabeceraIn;

import java.util.List;
import java.util.Optional;

public class FacturaCabeceraService implements FacturaCabeceraIn {

    private final FacturaCabeceraIn facturaCabeceraIn;

    public FacturaCabeceraService(FacturaCabeceraIn facturaCabeceraIn) {

        this.facturaCabeceraIn = facturaCabeceraIn;
    }

    @Override
    public FacturaCabecera Crear(FacturaCabecera facturaCabecera) {

        return facturaCabeceraIn.Crear(facturaCabecera);
    }

    @Override
    public Optional<FacturaCabecera> Actualizar(Long id, FacturaCabecera facturaCabecera) {
        return facturaCabeceraIn.Actualizar(id,facturaCabecera );
    }

    @Override
    public Optional<FacturaCabecera> GetFacturaCabecera(Long id) {
        return facturaCabeceraIn.GetFacturaCabecera(id);
    }

    @Override
    public List<FacturaCabecera> GetFacturaCabeceras() {

        return facturaCabeceraIn.GetFacturaCabeceras();
    }

    @Override
    public Boolean BorrarFacturaCabecera(Long id) {
        return facturaCabeceraIn.BorrarFacturaCabecera(id);
    }
}
