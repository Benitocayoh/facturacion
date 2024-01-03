package com.hexagonal.ejercicio.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class FacturaDetalle {
    private Long detalle_id;
    private Long factura_id;
    private Long producto_id;
    private Long cantidad;
    private Double precio_unitario;
    private Double subtotal;

    public FacturaDetalle(long detalle_id, Long factura_id, Long producto_id, Long cantidad, Double precio_unitario, Double subtotal) {
        this.detalle_id = detalle_id;
        this.factura_id = factura_id;
        this.producto_id = producto_id;
        this.cantidad= cantidad;
        this.precio_unitario = precio_unitario;
        this.subtotal = subtotal;

    }
}
