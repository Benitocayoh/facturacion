package com.hexagonal.ejercicio.infrastructure.config;

import com.hexagonal.ejercicio.aplication.service.FacturaCabeceraService;
import com.hexagonal.ejercicio.aplication.service.FacturaDetalleService;
import com.hexagonal.ejercicio.aplication.service.ProductoService;
import com.hexagonal.ejercicio.aplication.service.personaService;
import com.hexagonal.ejercicio.aplication.usecase.FacturaCabeceraServiceImpl;
import com.hexagonal.ejercicio.aplication.usecase.FacturaDetalleServiceImpl;
import com.hexagonal.ejercicio.aplication.usecase.ProductoServiceImpl;
import com.hexagonal.ejercicio.aplication.usecase.personaServiceImpl;
import com.hexagonal.ejercicio.domain.ports.out.FacturaCabeceraOut;
import com.hexagonal.ejercicio.domain.ports.out.FacturaDetalleOut;
import com.hexagonal.ejercicio.domain.ports.out.ProductoOut;
import com.hexagonal.ejercicio.domain.ports.out.personaOut;
import com.hexagonal.ejercicio.infrastructure.repository.FacturaCabeceraJPARepositoryAdapter;
import com.hexagonal.ejercicio.infrastructure.repository.FacturaDetalleJPARepositoryAdapter;
import com.hexagonal.ejercicio.infrastructure.repository.ProductoJPARepositoryAdapter;
import com.hexagonal.ejercicio.infrastructure.repository.personaJPARepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class aplicationConfig {

    @Bean
    public personaService personaService(personaOut personaOut){
        return new personaService(new personaServiceImpl(personaOut));
    }

    @Bean
    public personaOut personaOut(personaJPARepositoryAdapter personaJPARepositoryAdapter){
        return personaJPARepositoryAdapter;
    }



    @Bean
    public ProductoService productoService  (ProductoOut productoOut){
        return new ProductoService(new ProductoServiceImpl(productoOut));
    }

    @Bean
    public ProductoOut productoOut(ProductoJPARepositoryAdapter productoJPARepositoryAdapter){
        return productoJPARepositoryAdapter;
    }

    @Bean
    public FacturaCabeceraService facturaCabeceraService  (FacturaCabeceraOut facturaCabeceraOut){
        return new FacturaCabeceraService(new FacturaCabeceraServiceImpl(facturaCabeceraOut));
    }

    @Bean
    public FacturaCabeceraOut facturaCabeceraOut(FacturaCabeceraJPARepositoryAdapter facturaCabeceraJPARepositoryAdapter){
        return facturaCabeceraJPARepositoryAdapter;
    }

    @Bean
    public FacturaDetalleService facturaDetalleService  (FacturaDetalleOut facturaDetalleOut){
        return new FacturaDetalleService(new FacturaDetalleServiceImpl(facturaDetalleOut));
    }

    @Bean
    public FacturaDetalleOut facturaDetalleOut(FacturaDetalleJPARepositoryAdapter facturaDetalleJPARepositoryAdapter){
        return facturaDetalleJPARepositoryAdapter;
    }



}
