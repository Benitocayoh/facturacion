package com.hexagonal.ejercicio.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class FacturaCabecera {
    private long factura_id;
    private String cliente_nombre;
    private String cliente_num_documento;
    private Date fecha_emision;
    private Double total;

    public FacturaCabecera(long factura_id, String cliente_nombre, String cliente_num_documento, Date fecha_emision, Double total) {
        this.factura_id = factura_id;
        this.cliente_nombre = cliente_nombre;
        this.cliente_num_documento = cliente_num_documento;
        this.fecha_emision= fecha_emision;
        this.total = total;
    }
}
