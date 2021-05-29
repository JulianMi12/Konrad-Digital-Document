package konrad.edu.co.kdd.controller;

import konrad.edu.co.kdd.entity.Ventanilla;
import konrad.edu.co.kdd.service.ServicesCiudad;
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
@RequestMapping(path = "ciudad")

public class CiudadController {

    @Autowired
    private ServicesCiudad ciudadService;

    @PostMapping(path = "crear")
    public @ResponseBody
    ResponseEntity crearCiudad(@RequestBody Ventanilla ventanilla) {
        try {
            ciudadService.crearCiudad(ventanilla);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
