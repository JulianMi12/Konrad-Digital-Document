package konrad.edu.co.rest1.service;

import konrad.edu.co.rest1.entity.Persona;
import konrad.edu.co.rest1.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Team 2
 */
@Service

public class ServicesPersona {

    @Autowired
    private PersonaRepository personaRepository;

    public void crearPersona(Persona persona) {
        personaRepository.save(persona);
    }

    public Persona readPersona() {
        return personaRepository.findById(1).get();
    }

    public void updatePersona(Persona persona) {
        personaRepository.save(persona);
    }

    public void deletePersona(Persona persona) {
        personaRepository.delete(persona);
    }
}
