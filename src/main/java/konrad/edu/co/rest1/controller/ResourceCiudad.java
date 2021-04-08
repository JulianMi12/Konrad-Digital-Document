package konrad.edu.co.rest1.controller;

import konrad.edu.co.rest1.service.ServicesCiudad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Team 2
 */

@RestController
@RequestMapping(path = "CRUD_CIUDAD")

public class ResourceCiudad {

    @Autowired
    private ServicesCiudad sc;

    @PostMapping(path = {"createCiudad/{code}"})
    public String retornarCreateCiudad(@PathVariable("code") int code) {
        return "Se esta creando una Ciudad con codigo \""+code+"\".";
    }

    @GetMapping(path = {"readCiudades/{empty}"})
    public String retornarReadCiudades(@PathVariable("empty") String empty) {
        String respuesta = sc.consultarCiudades(Boolean.parseBoolean(empty));
        return respuesta;
    }

    @PutMapping(path = {"updateCiudades/{code}/{name}"})
    public String retornarUpdateCiudades(@PathVariable("code") int code, @PathVariable("name") String name) {
        return "Actualizando Ciudad con codigo \"" + code + "\" a nuevo nombre \"" + name + "\".";
    }

    @DeleteMapping(path = {"deleteCiudades/{code}/{exist}"})
    public String retornarDeleteCiudades(@PathVariable("code") int code, @PathVariable("exist") String exist) {
        String respuesta = sc.deleteCuidades(code, Boolean.parseBoolean(exist));
        return respuesta;
    }
}
