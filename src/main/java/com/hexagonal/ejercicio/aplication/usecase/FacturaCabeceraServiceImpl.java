package com.hexagonal.ejercicio.aplication.usecase;

import com.hexagonal.ejercicio.domain.model.FacturaCabecera;
import com.hexagonal.ejercicio.domain.ports.in.FacturaCabeceraIn;
import com.hexagonal.ejercicio.domain.ports.out.FacturaCabeceraOut;

import java.util.List;
import java.util.Optional;

public class FacturaCabeceraServiceImpl implements FacturaCabeceraIn {

    private final FacturaCabeceraOut facturaCabeceraOut;

    public FacturaCabeceraServiceImpl(FacturaCabeceraOut facturaCabeceraOut) {
        this.facturaCabeceraOut = facturaCabeceraOut;
    }

    @Override
    public FacturaCabecera Crear(FacturaCabecera facturaCabecera) {

        return facturaCabeceraOut.Crear(facturaCabecera);
    }

    @Override
    public Optional<FacturaCabecera> Actualizar(Long id, FacturaCabecera facturaCabecera) {
        return facturaCabeceraOut.Actualizar(id,facturaCabecera);
    }

    @Override
    public Optional<FacturaCabecera> GetFacturaCabecera(Long id) {
        return facturaCabeceraOut.GetFacturaCabecera(id);
    }

    @Override
    public List<FacturaCabecera> GetFacturaCabeceras() {
        return facturaCabeceraOut.GetFacturaCabeceras();
    }

    @Override
    public Boolean BorrarFacturaCabecera(Long id) {
        return facturaCabeceraOut.BorrarFacturaCabecera(id);
    }
}
