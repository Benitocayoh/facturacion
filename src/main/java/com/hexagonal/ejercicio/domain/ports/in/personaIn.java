package com.hexagonal.ejercicio.domain.ports.in;

import com.hexagonal.ejercicio.domain.model.persona;

import java.util.Optional;

public interface personaIn {
    persona crearPersona(persona persona);
    Optional<persona> getPersona(Long id);
    Optional<persona> actualizaPersona(Long id, persona persona);
    Boolean borrarPersona(Long id);

}
