package konrad.edu.co.rest1.controller;

import konrad.edu.co.rest1.entity.Persona;
import konrad.edu.co.rest1.service.ServicesPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping(path = "persona")

public class PersonaController {

    @Autowired
    private ServicesPersona personaService;

    @PostMapping(path = "crear")
    public @ResponseBody
    ResponseEntity crearPersona(@RequestBody Persona persona) {
        try {
            personaService.crearPersona(persona);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "read")
    public ResponseEntity readPersona() {
        try {
            Persona persona = personaService.readPersona();
            return new ResponseEntity(persona, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path = "update")
    ResponseEntity updatePersona(@RequestBody Persona persona) {
        try {
            personaService.updatePersona(persona);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(path = "delete")
    ResponseEntity deletePersona(@RequestBody Persona persona) {
        try {
            personaService.deletePersona(persona);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
