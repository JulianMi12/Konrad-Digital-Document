package konrad.edu.co.rest1.service;

import org.springframework.stereotype.Service;

/**
 *
 * @author Team 2
 */

@Service

public class ServicesCiudad {

    public String consultarCiudades(boolean empty) {
        if (empty) {
            return "Estas son las Ciudades actuales.";
        } else {
            return "En el momento no hay ninguna Ciudad añadida.";
        }
    }

    public String deleteCuidades(int code, boolean exist) {
        if (exist) {
            return "Eliminando Ciudad con codigo \"" + code + "\".";
        } else {
            return "Ciudad con codigo \"" + code + "\" inexistente";
        }
    }
}
