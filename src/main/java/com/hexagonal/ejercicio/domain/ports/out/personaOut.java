package com.hexagonal.ejercicio.domain.ports.out;

import com.hexagonal.ejercicio.domain.model.persona;

import java.util.Optional;

public interface personaOut {
    persona crearPersona(persona persona);
    Optional<persona> getPersona(Long id);
    Optional<persona> actualizaPersona(Long id, persona persona);
    boolean borrarPersona(Long id);
}
