package com.hexagonal.ejercicio.domain.ports.out;

import com.hexagonal.ejercicio.domain.model.FacturaCabecera;

import java.util.List;
import java.util.Optional;

public interface FacturaCabeceraOut {
    FacturaCabecera Crear(FacturaCabecera facturaCabecera);
    Optional<FacturaCabecera> Actualizar (Long id, FacturaCabecera facturaCabecera);
    Optional<FacturaCabecera> GetFacturaCabecera (Long id);
    List<FacturaCabecera> GetFacturaCabeceras ();
    Boolean BorrarFacturaCabecera(Long id);
}
