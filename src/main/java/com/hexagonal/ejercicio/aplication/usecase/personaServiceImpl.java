package com.hexagonal.ejercicio.aplication.usecase;

import com.hexagonal.ejercicio.domain.model.persona;
import com.hexagonal.ejercicio.domain.ports.in.personaIn;
import com.hexagonal.ejercicio.domain.ports.out.personaOut;

import java.util.Optional;

public class personaServiceImpl implements personaIn {

    private final personaOut personaOut;

    public personaServiceImpl(personaOut personaOut) {
        this.personaOut = personaOut;
    }

    @Override
    public persona crearPersona(persona persona) {
        return personaOut.crearPersona(persona);
    }

    @Override
    public Optional<persona> getPersona(Long id) {
        return personaOut.getPersona(id);
    }

    @Override
    public Optional<persona> actualizaPersona(Long id, persona persona) {
        return personaOut.actualizaPersona(id,persona);
    }

    @Override
    public Boolean borrarPersona(Long id) {
        return personaOut.borrarPersona(id);
    }
}
