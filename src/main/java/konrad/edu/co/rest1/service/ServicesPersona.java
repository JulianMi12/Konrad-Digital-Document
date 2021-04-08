package konrad.edu.co.rest1.service;

import org.springframework.stereotype.Service;

/**
 *
 * @author Team 2
 */

@Service

public class ServicesPersona {

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
