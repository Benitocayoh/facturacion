package com.hexagonal.ejercicio.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class persona {
    private long id;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private String genero;

    public persona(long id, String nombre, String apellido, Date fechaNacimiento, String genero) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
    }
}
