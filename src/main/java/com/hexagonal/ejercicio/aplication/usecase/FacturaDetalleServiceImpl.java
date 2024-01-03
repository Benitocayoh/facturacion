package com.hexagonal.ejercicio.aplication.usecase;

import com.hexagonal.ejercicio.domain.model.FacturaDetalle;
import com.hexagonal.ejercicio.domain.ports.in.FacturaDetalleIn;
import com.hexagonal.ejercicio.domain.ports.out.FacturaCabeceraOut;
import com.hexagonal.ejercicio.domain.ports.out.FacturaDetalleOut;

import java.util.List;
import java.util.Optional;

public class FacturaDetalleServiceImpl implements FacturaDetalleIn {

    private final FacturaDetalleOut facturaDetalleOut;

    public FacturaDetalleServiceImpl(FacturaDetalleOut facturaDetalleOut) {
        this.facturaDetalleOut = facturaDetalleOut;

    }

    @Override
    public FacturaDetalle Crear(FacturaDetalle facturaDetalle) {
        return facturaDetalleOut.Crear(facturaDetalle);
    }

    @Override
    public Optional<FacturaDetalle> Actualizar(Long id, FacturaDetalle facturaDetalle) {
        return facturaDetalleOut.Actualizar(id,facturaDetalle);
    }

    @Override
    public Optional<FacturaDetalle> GetFacturaDetalle(Long id) {
        return facturaDetalleOut.GetFacturaDetalle(id);
    }

    @Override
    public List<FacturaDetalle> GetFacturaDetalle() {
        return facturaDetalleOut.GetFacturaDetalle();
    }

    @Override
    public Boolean BorrarFacturaDetalle(Long id) {
        return facturaDetalleOut.BorrarFacturaDetalle(id);
    }
}
