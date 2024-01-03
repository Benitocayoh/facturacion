package com.hexagonal.ejercicio.infrastructure.repository;

import com.hexagonal.ejercicio.domain.model.Producto;
import com.hexagonal.ejercicio.domain.ports.out.ProductoOut;
import com.hexagonal.ejercicio.infrastructure.entity.PersonaEntity;
import com.hexagonal.ejercicio.infrastructure.entity.ProductoEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProductoJPARepositoryAdapter implements ProductoOut {

    private final ProductoJPAReposity productoJPAReposity;

    public ProductoJPARepositoryAdapter(ProductoJPAReposity prodctoJPAReposity) {
        this.productoJPAReposity = prodctoJPAReposity;
    }


    @Override
    public Producto Crear(Producto producto) {
        ProductoEntity productoEntity = ProductoEntity.fromDomainModel(producto);
        return productoJPAReposity.save(productoEntity).toDomainModel();
    }

    @Override
    public Optional<Producto> Actualizar(Long id, Producto producto) {
        if(productoJPAReposity.existsById(id)){
            ProductoEntity productoEntity = ProductoEntity.fromDomainModel(producto);
            return Optional.of(productoJPAReposity.save(productoEntity).toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public Optional<Producto> GetProducto(Long id) {
        try
        {
            return productoJPAReposity.findById(id).map(ProductoEntity::toDomainModel);
        }
        catch (Exception me)
        {
            System.out.println("error"+me.getMessage());

        }
        return Optional.empty();
    }

    @Override
    public List<Producto> GetProductos() {
        List<ProductoEntity> listProductoEntity;
        listProductoEntity = productoJPAReposity.findAll();
        List<Producto> LisProducto=new ArrayList<>();
        for (ProductoEntity e:listProductoEntity) {
            Producto producto=new Producto(e.getProducto_id(),e.getNombre(),e.getDescripcion(),e.getPrecio(), e.getStock());
            LisProducto.add(producto);
        }
        if (!LisProducto.isEmpty())
        {
            return LisProducto;
        }
        else
        {
            return null;
        }
    }

    @Override
    public Boolean borrarProducto(Long id) {
        if(productoJPAReposity.existsById(id)){
            productoJPAReposity.deleteById(id);
            return true;
        }
        return false;
    }
}
