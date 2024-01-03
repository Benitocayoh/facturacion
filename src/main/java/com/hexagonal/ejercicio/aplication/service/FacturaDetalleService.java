package com.hexagonal.ejercicio.aplication.service;

import com.hexagonal.ejercicio.domain.model.FacturaDetalle;
import com.hexagonal.ejercicio.domain.ports.in.FacturaDetalleIn;

import java.util.List;
import java.util.Optional;

public class FacturaDetalleService implements FacturaDetalleIn {

    private final FacturaDetalleIn facturaDetalleIn;

    public FacturaDetalleService(FacturaDetalleIn facturaDetalleIn) {
        this.facturaDetalleIn = facturaDetalleIn;
    }

    @Override
    public FacturaDetalle Crear(FacturaDetalle facturaDetalle) {
        return facturaDetalleIn.Crear(facturaDetalle);
    }

    @Override
    public Optional<FacturaDetalle> Actualizar(Long id, FacturaDetalle facturaDetalle) {
        return facturaDetalleIn.Actualizar(id,facturaDetalle);
    }

    @Override
    public Optional<FacturaDetalle> GetFacturaDetalle(Long id) {
        return facturaDetalleIn.GetFacturaDetalle(id);
    }

    @Override
    public List<FacturaDetalle> GetFacturaDetalle() {
        return facturaDetalleIn.GetFacturaDetalle();
    }

    @Override
    public Boolean BorrarFacturaDetalle(Long id) {
        return facturaDetalleIn.BorrarFacturaDetalle(id);
    }
}
