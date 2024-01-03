package com.hexagonal.ejercicio.infrastructure.entity;

import com.hexagonal.ejercicio.domain.model.persona;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

//import javax.persistence.*;
import java.util.Date;
@Entity
@Getter
@Setter
@Table(name = "Personas")
public class PersonaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private String genero;

    public PersonaEntity() {
    }

    public PersonaEntity(Long id, String nombre, String apellido, Date fechaNacimiento, String genero) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
    }

    public static PersonaEntity fromDomainModel(persona persona){
        return new PersonaEntity(persona.getId(),persona.getNombre(),persona.getApellido(),persona.getFechaNacimiento(),persona.getGenero());
    }

    public persona toDomainModel(){
        return new persona(id,nombre,apellido,fechaNacimiento,genero);
    }

}
