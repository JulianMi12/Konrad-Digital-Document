package konrad.edu.co.rest1.controller;

import java.util.List;
import konrad.edu.co.rest1.entity.Ciudad;
import konrad.edu.co.rest1.service.ServicesCiudad;
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
@RequestMapping(path = "ciudad")

public class CiudadController {

    @Autowired
    private ServicesCiudad ciudadService;

    @PostMapping(path = "crear")
    public @ResponseBody
    ResponseEntity crearCiudad(@RequestBody Ciudad ciudad) {
        try {
            ciudadService.crearCiudad(ciudad);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "read")
    public ResponseEntity readCiudades() {
        try {
            Ciudad ciudad = ciudadService.readCiudad();
            return new ResponseEntity(ciudad, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path = "update")
    ResponseEntity updateCiudades(@RequestBody Ciudad ciudad) {
        try {
            ciudadService.updateCiudad(ciudad);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(path = "delete")
    ResponseEntity deleteCiudades(@RequestBody Ciudad ciudad) {
        try {
            ciudadService.deleteCiudad(ciudad);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
