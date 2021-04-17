package konrad.edu.co.rest1.controller;

import konrad.edu.co.rest1.service.ServicesPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Team 2
 */

@RestController
@RequestMapping(path = "CRUD_PERSONA")

public class PersonaController {
    
    @Autowired
    private ServicesPersona sp;

    @PostMapping(path = {"createPersona/{code}/{name}"})
    public String retornarCreatePersona(@PathVariable("code") int code, @PathVariable("name") String name) {
        return "Se esta creando una Persona con codigo \""+code+"\" y nombre \""+name+"\"";
    }

    @GetMapping(path = {"readPersona/{empty}"})
    public String retornarReadPersona(@PathVariable("empty") String empty) {
        String respuesta = sp.consultarPersonas(Boolean.parseBoolean(empty));
        return respuesta;
    }

    @PutMapping(path = {"updatePersona/{code}/{name}"})
    public String retornarUpdatePersona(@PathVariable("code") int code, @PathVariable("name") String name) {
        return "Actualizando Persona con codigo \"" + code + "\" a nuevo nombre \"" + name + "\".";
    }

    @DeleteMapping(path = {"deletePersona/{code}/{exist}"})
    public String retornarDeletePersona(@PathVariable("code") int code, @PathVariable("exist") String exist) {
        String respuesta = sp.deletePersonas(code, Boolean.parseBoolean(exist));
        return respuesta;
    }
}
