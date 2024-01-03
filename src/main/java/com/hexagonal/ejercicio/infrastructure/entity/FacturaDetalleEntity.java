package com.hexagonal.ejercicio.infrastructure.entity;

import com.hexagonal.ejercicio.domain.model.FacturaCabecera;
import com.hexagonal.ejercicio.domain.model.FacturaDetalle;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table (name = "FacturaDetalle")
public class FacturaDetalleEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long detalle_id;
    private Long factura_id;
    private Long producto_id;
    private Long cantidad;
    private Double precio_unitario;
    private Double subtotal;
    /*@OneToOne
    @JoinColumn(name = "producto_id")
    ProductoEntity Productos;
    @OneToOne
    @JoinColumn(name = "factura_id")
    FacturaCabeceraEntity FacturaCabecera;*/


    public FacturaDetalleEntity(){}

    public FacturaDetalleEntity(Long detalle_id, Long factura_id, Long producto_id, Long cantidad, Double precio_unitario, Double subtotal) {
        this.detalle_id = detalle_id;
        this.factura_id = factura_id;
        this.producto_id = producto_id;
        this.cantidad = cantidad;
        this.precio_unitario = precio_unitario;
        this.subtotal = subtotal;

    }

    public static FacturaDetalleEntity fromDomainModel(FacturaDetalle facturaDetalle){
        return new FacturaDetalleEntity(facturaDetalle.getDetalle_id(),facturaDetalle.getFactura_id(),facturaDetalle.getProducto_id(),facturaDetalle.getCantidad(),facturaDetalle.getPrecio_unitario(),facturaDetalle.getSubtotal());
    }

    public FacturaDetalle toDomainModel(){
        return new FacturaDetalle(detalle_id,factura_id,producto_id,cantidad,precio_unitario,subtotal);
    }
}
