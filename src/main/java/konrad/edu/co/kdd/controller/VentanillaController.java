package konrad.edu.co.kdd.controller;

import konrad.edu.co.kdd.entity.Ventanilla;
import konrad.edu.co.kdd.service.VentanillaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Grupo 2
 */
@RestController
@RequestMapping(path = "usuario")

public class VentanillaController {

    @Autowired
    private VentanillaService ciudadService;

    @PostMapping(path = "crear")
    public @ResponseBody
    ResponseEntity crearUsuario(@RequestBody Ventanilla ventanilla) {
        try {
            ciudadService.crearUsuario(ventanilla);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
