package com.hexagonal.ejercicio.infrastructure.controller;

import com.hexagonal.ejercicio.aplication.service.personaService;
import com.hexagonal.ejercicio.domain.model.persona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/personas")
public class personaController {
    private final personaService personaService;

    public personaController(personaService personaService) {
        this.personaService = personaService;
    }

    @PostMapping
    public ResponseEntity<persona> crear (@RequestBody persona persona){
        persona creaPersona=personaService.crearPersona(persona);
        return new ResponseEntity<>(creaPersona, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<persona> getPersona(@PathVariable Long id){
      return personaService.getPersona(id)
              .map(persona-> new ResponseEntity<>(persona,HttpStatus.OK))
              .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<persona> UpdatePersona(@PathVariable Long id, @RequestBody persona persona){
        return personaService.actualizaPersona(id,persona)
                .map(per-> new ResponseEntity<>(per,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> DeletePersona(@PathVariable Long id, @RequestBody persona persona){
        if (personaService.borrarPersona(id))
        {
           return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }else {
           return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
