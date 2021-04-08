package konrad.edu.co.rest1.service;

import org.springframework.stereotype.Service;

/**
 *
 * @author Team 2
 */

@Service

public class ServicesTipoDocumento {

    public String consultarTDocumento(boolean empty) {
        if (empty) {
            return "Estas son Tipos de Documento actuales.";
        } else {
            return "En el momento no hay ningun Tipo de Documento añadido.";
        }
    }

    public String deleteTDocumento(int code, boolean exist) {
        if (exist) {
            return "Eliminando Tipo de Documento con codigo \"" + code + "\".";
        } else {
            return "Tipo de Documento con codigo \"" + code + "\" inexistente";
        }
    }
}
