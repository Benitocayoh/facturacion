package com.hexagonal.ejercicio.domain.ports.in;

import com.hexagonal.ejercicio.domain.model.FacturaCabecera;
import com.hexagonal.ejercicio.domain.model.Producto;

import java.util.List;
import java.util.Optional;

public interface FacturaCabeceraIn {
    FacturaCabecera Crear(FacturaCabecera facturaCabecera);
    Optional<FacturaCabecera> Actualizar (Long id, FacturaCabecera facturaCabecera);
    Optional<FacturaCabecera> GetFacturaCabecera (Long id);
    List<FacturaCabecera> GetFacturaCabeceras ();
    Boolean BorrarFacturaCabecera(Long id);
}
