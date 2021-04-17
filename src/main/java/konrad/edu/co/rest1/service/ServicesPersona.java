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

    public String consultarPersonas(boolean empty) {
        if (empty) {
            return "Estas son las Personas actuales.";
        } else {
            return "En el momento no hay ninguna Persona añadida.";
        }
    }

    public String deletePersonas(int code, boolean exist) {
        if (exist) {
            return "Eliminando Persona con codigo \"" + code + "\".";
        } else {
            return "Persona con codigo \"" + code + "\" inexistente";
        }
    }
}
