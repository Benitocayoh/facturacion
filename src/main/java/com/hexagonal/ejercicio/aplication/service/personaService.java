package com.hexagonal.ejercicio.aplication.service;

import com.hexagonal.ejercicio.domain.model.persona;
import com.hexagonal.ejercicio.domain.ports.in.personaIn;

import java.util.Optional;

public class personaService implements personaIn {

    private final personaIn personaIn;

    public personaService(personaIn personaIn) {
        this.personaIn = personaIn;
    }

    @Override
    public persona crearPersona(persona persona) {
        return personaIn.crearPersona(persona);
    }

    @Override
    public Optional<persona> getPersona(Long id) {
        return personaIn.getPersona(id);
    }

    @Override
    public Optional<persona> actualizaPersona(Long id, persona persona) {
        return personaIn.actualizaPersona(id,persona);
    }

    @Override
    public Boolean borrarPersona(Long id) {
        return personaIn.borrarPersona(id);
    }
}
