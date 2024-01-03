package com.hexagonal.ejercicio.infrastructure.repository;

import com.hexagonal.ejercicio.domain.model.FacturaCabecera;
import com.hexagonal.ejercicio.domain.model.Producto;
import com.hexagonal.ejercicio.domain.ports.out.FacturaCabeceraOut;
import com.hexagonal.ejercicio.infrastructure.entity.FacturaCabeceraEntity;
import com.hexagonal.ejercicio.infrastructure.entity.ProductoEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Component
public class FacturaCabeceraJPARepositoryAdapter implements FacturaCabeceraOut {

    private final FacturaCabeceraJPARepository facturaCabeceraJPARepository;

    public FacturaCabeceraJPARepositoryAdapter(FacturaCabeceraJPARepository facturaCabeceraJPARepository) {
        this.facturaCabeceraJPARepository = facturaCabeceraJPARepository;
    }

    @Override
    public FacturaCabecera Crear(FacturaCabecera facturaCabecera) {
        FacturaCabeceraEntity facturaCabeceraEntity = FacturaCabeceraEntity.fromDomainModel(facturaCabecera);
        return facturaCabeceraJPARepository.save(facturaCabeceraEntity).toDomainModel();
    }

    @Override
    public Optional<FacturaCabecera> Actualizar(Long id, FacturaCabecera facturaCabecera) {
        if(facturaCabeceraJPARepository.existsById(id)){
            FacturaCabeceraEntity facturaCabeceraEntity = FacturaCabeceraEntity.fromDomainModel(facturaCabecera);
            return Optional.of(facturaCabeceraJPARepository.save(facturaCabeceraEntity).toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public Optional<FacturaCabecera> GetFacturaCabecera(Long id) {
        try
        {
            return facturaCabeceraJPARepository.findById(id).map(FacturaCabeceraEntity::toDomainModel);
        }
        catch (Exception me)
        {
            System.out.println("error"+me.getMessage());

        }
        return Optional.empty();
    }

    @Override
    public List<FacturaCabecera> GetFacturaCabeceras() {
        List<FacturaCabeceraEntity> listFacturaCabeceraEntity;
        listFacturaCabeceraEntity = facturaCabeceraJPARepository.findAll();
        List<FacturaCabecera> LisFacturaCabecera=new ArrayList<>();
        for (FacturaCabeceraEntity e:listFacturaCabeceraEntity) {
            FacturaCabecera facturaCabecera=new FacturaCabecera(e.getFactura_id(),e.getCliente_nombre(),e.getCliente_num_documento(),e.getFecha_emision(), e.getTotal());
            LisFacturaCabecera.add(facturaCabecera);
        }
        if (!LisFacturaCabecera.isEmpty())
        {
            return LisFacturaCabecera;
        }
        else
        {
            return null;
        }
    }

    @Override
    public Boolean BorrarFacturaCabecera(Long id) {
        if(facturaCabeceraJPARepository.existsById(id)){
            facturaCabeceraJPARepository.deleteById(id);
            return true;
        }
        return false;
    }
}
