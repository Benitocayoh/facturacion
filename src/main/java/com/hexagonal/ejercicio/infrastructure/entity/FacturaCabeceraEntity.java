package com.hexagonal.ejercicio.infrastructure.entity;

import com.hexagonal.ejercicio.domain.model.FacturaCabecera;
import com.hexagonal.ejercicio.domain.model.persona;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Entity
@Getter
@Setter
@Table (name = "FacturaCabecera")
public class FacturaCabeceraEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long factura_id;
    private String cliente_nombre;
    private String cliente_num_documento;
    private Date fecha_emision;
    private Double total;


    public FacturaCabeceraEntity(){}

    public FacturaCabeceraEntity(long factura_id, String cliente_nombre, String cliente_num_documento, Date fecha_emision, Double total) {
        this.factura_id = factura_id;
        this.cliente_nombre = cliente_nombre;
        this.cliente_num_documento = cliente_num_documento;
        this.fecha_emision = fecha_emision;
        this.total = total;
    }

    public static FacturaCabeceraEntity fromDomainModel(FacturaCabecera facturaCabecera){
        return new FacturaCabeceraEntity(facturaCabecera.getFactura_id(),facturaCabecera.getCliente_nombre(),facturaCabecera.getCliente_num_documento(),facturaCabecera.getFecha_emision(),facturaCabecera.getTotal());
    }

    public FacturaCabecera toDomainModel(){
        return new FacturaCabecera(factura_id,cliente_nombre,cliente_num_documento,fecha_emision,total);
    }


}
