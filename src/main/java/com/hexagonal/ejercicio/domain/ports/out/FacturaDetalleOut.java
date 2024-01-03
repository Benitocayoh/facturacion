package com.hexagonal.ejercicio.domain.ports.out;

import com.hexagonal.ejercicio.domain.model.FacturaDetalle;

import java.util.List;
import java.util.Optional;

public interface FacturaDetalleOut {
    FacturaDetalle Crear(FacturaDetalle facturaDetalle);
    Optional<FacturaDetalle> Actualizar (Long id, FacturaDetalle facturaDetalle);
    Optional<FacturaDetalle> GetFacturaDetalle (Long id);
    List<FacturaDetalle> GetFacturaDetalle ();
    Boolean BorrarFacturaDetalle(Long id);
}
