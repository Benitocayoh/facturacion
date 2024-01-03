package com.hexagonal.ejercicio.infrastructure.repository;

import com.hexagonal.ejercicio.domain.model.FacturaCabecera;
import com.hexagonal.ejercicio.domain.model.FacturaDetalle;
import com.hexagonal.ejercicio.domain.ports.out.FacturaDetalleOut;
import com.hexagonal.ejercicio.infrastructure.entity.FacturaCabeceraEntity;
import com.hexagonal.ejercicio.infrastructure.entity.FacturaDetalleEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class FacturaDetalleJPARepositoryAdapter implements FacturaDetalleOut {

    private final FacturaDetalleJPARepository facturaDetalleJPARepository;

    public FacturaDetalleJPARepositoryAdapter(FacturaDetalleJPARepository facturaDetalleJPARepository) {
        this.facturaDetalleJPARepository = facturaDetalleJPARepository;
    }

    @Override
    public FacturaDetalle Crear(FacturaDetalle facturaDetalle) {
        FacturaDetalleEntity facturaCabeceraEntity = FacturaDetalleEntity.fromDomainModel(facturaDetalle);
        return facturaDetalleJPARepository.save(facturaCabeceraEntity).toDomainModel();
    }

    @Override
    public Optional<FacturaDetalle> Actualizar(Long id, FacturaDetalle facturaDetalle) {
        if(facturaDetalleJPARepository.existsById(id)){
            FacturaDetalleEntity facturaDetalleEntity = FacturaDetalleEntity.fromDomainModel(facturaDetalle);
            return Optional.of(facturaDetalleJPARepository.save(facturaDetalleEntity).toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public Optional<FacturaDetalle> GetFacturaDetalle(Long id) {
        try
        {
            return facturaDetalleJPARepository.findById(id).map(FacturaDetalleEntity::toDomainModel);
        }
        catch (Exception me)
        {
            System.out.println("error"+me.getMessage());

        }
        return Optional.empty();
    }

    @Override
    public List<FacturaDetalle> GetFacturaDetalle() {
        List<FacturaDetalleEntity> listFacturaDetalleEntity;
        listFacturaDetalleEntity = facturaDetalleJPARepository.findAll();
        List<FacturaDetalle> LisFacturaDetalle=new ArrayList<>();
        for (FacturaDetalleEntity e:listFacturaDetalleEntity) {
            FacturaDetalle facturaDetalle=new FacturaDetalle(e.getDetalle_id(),e.getFactura_id(),e.getProducto_id(),e.getCantidad(),e.getPrecio_unitario(), e.getSubtotal());
            LisFacturaDetalle.add(facturaDetalle);
        }
        if (!LisFacturaDetalle.isEmpty())
        {
            return LisFacturaDetalle;
        }
        else
        {
            return null;
        }
    }

    @Override
    public Boolean BorrarFacturaDetalle(Long id) {
        if(facturaDetalleJPARepository.existsById(id)){
            facturaDetalleJPARepository.deleteById(id);
            return true;
        }
        return false;
    }
}
