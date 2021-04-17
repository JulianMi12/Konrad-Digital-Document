package konrad.edu.co.rest1.controller;

import konrad.edu.co.rest1.entity.Ciudad;
import konrad.edu.co.rest1.service.ServicesCiudad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Team 2
 */
@RestController
@RequestMapping(path = "CRUD_CIUDAD")

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

    @GetMapping(path = {"readCiudades/{empty}"})
    public String retornarReadCiudades(@PathVariable("empty") String empty) {
        String respuesta = ciudadService.consultarCiudades(Boolean.parseBoolean(empty));
        return respuesta;
    }

    @PutMapping(path = {"updateCiudades/{code}/{name}"})
    public String retornarUpdateCiudades(@PathVariable("code") int code, @PathVariable("name") String name) {
        return "Actualizando Ciudad con codigo \"" + code + "\" a nuevo nombre \"" + name + "\".";
    }

    @DeleteMapping(path = {"deleteCiudades/{code}/{exist}"})
    public String retornarDeleteCiudades(@PathVariable("code") int code, @PathVariable("exist") String exist) {
        String respuesta = ciudadService.deleteCuidades(code, Boolean.parseBoolean(exist));
        return respuesta;
    }
}
