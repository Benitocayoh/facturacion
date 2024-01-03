package com.hexagonal.ejercicio.infrastructure.repository;

import com.hexagonal.ejercicio.domain.model.persona;
import com.hexagonal.ejercicio.domain.ports.out.personaOut;
import com.hexagonal.ejercicio.infrastructure.entity.PersonaEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class personaJPARepositoryAdapter implements personaOut {


    private final personaJPARepository personaJPARepository;

    public personaJPARepositoryAdapter(personaJPARepository personaJPARepository) {
        this.personaJPARepository = personaJPARepository;
    }

    @Override
    public persona crearPersona(persona persona) {
        PersonaEntity personaEntity = PersonaEntity.fromDomainModel(persona);
        return personaJPARepository.save(personaEntity).toDomainModel();
    }

    @Override
    public Optional<persona> getPersona(Long id) {
        try
        {
            return personaJPARepository.findById(id).map(PersonaEntity::toDomainModel);
        }
        catch (Exception me)
        {
            System.out.println("error"+me.getMessage());

        }
        return Optional.empty();
    }

    @Override
    public Optional<persona> actualizaPersona(Long id, persona persona) {
        if(personaJPARepository.existsById(id)){
            PersonaEntity personaEntity = PersonaEntity.fromDomainModel(persona);
            return Optional.of(personaJPARepository.save(personaEntity).toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public boolean borrarPersona(Long id) {
        if(personaJPARepository.existsById(id)){
            personaJPARepository.deleteById(id);
            return true;
        }
        return false;
    }
}
