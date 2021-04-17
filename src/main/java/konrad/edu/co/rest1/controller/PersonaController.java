package konrad.edu.co.rest1.controller;

import konrad.edu.co.rest1.entity.Ciudad;
import konrad.edu.co.rest1.entity.Persona;
import konrad.edu.co.rest1.service.ServicesPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Team 2
 */

@RestController
@RequestMapping(path = "CRUD_PERSONA")

public class PersonaController {
    
    @Autowired
    private ServicesPersona personaService;

    @PostMapping(path = "crear")
    public @ResponseBody
    ResponseEntity crearCiudad(@RequestBody Persona persona) {
        try {
            personaService.crearPersona(persona);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = {"readPersona/{empty}"})
    public String retornarReadPersona(@PathVariable("empty") String empty) {
        String respuesta = personaService.consultarPersonas(Boolean.parseBoolean(empty));
        return respuesta;
    }

    @PutMapping(path = {"updatePersona/{code}/{name}"})
    public String retornarUpdatePersona(@PathVariable("code") int code, @PathVariable("name") String name) {
        return "Actualizando Persona con codigo \"" + code + "\" a nuevo nombre \"" + name + "\".";
    }

    @DeleteMapping(path = {"deletePersona/{code}/{exist}"})
    public String retornarDeletePersona(@PathVariable("code") int code, @PathVariable("exist") String exist) {
        String respuesta = personaService.deletePersonas(code, Boolean.parseBoolean(exist));
        return respuesta;
    }
}
