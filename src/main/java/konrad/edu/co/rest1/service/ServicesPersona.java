package konrad.edu.co.rest1.service;

import java.util.ArrayList;
import java.util.Iterator;
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

    public ArrayList<Persona> readPersona() {
        ArrayList<Persona> personas = new ArrayList<>();
        Iterable rec1;
        rec1 = personaRepository.findAll();
        Iterator<Persona> rec2 = rec1.iterator();
        while(rec2.hasNext()){
            Persona persona;
            persona = rec2.next();
            personas.add(persona);
        }
        return personas;
    }

    public void updatePersona(Persona persona) {
        personaRepository.save(persona);
    }

    public void deletePersona(Persona persona) {
        personaRepository.delete(persona);
    }
}
