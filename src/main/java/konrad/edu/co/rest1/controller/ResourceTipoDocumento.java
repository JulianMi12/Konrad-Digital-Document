package konrad.edu.co.rest1.controller;

import konrad.edu.co.rest1.service.ServicesTipoDocumento;
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
@RequestMapping(path = "CRUD_T_DOCUMENTO")

public class ResourceTipoDocumento {

    @Autowired
    private ServicesTipoDocumento st;

    @PostMapping(path = {"createTipoDocumento/{code}/{name}"})
    public String retornarCreateTipoDocumento(@PathVariable("code") int code, @PathVariable("name") String name) {
        return "Se esta creando un Tipo de Documento con codigo \"" + code + "\" y nombre \"" + name + "\"";
    }

    @GetMapping(path = {"readTipoDocumento/{empty}"})
    public String retornarReadTipoDocumento(@PathVariable("empty") String empty) {
        String respuesta = st.consultarTDocumento(Boolean.parseBoolean(empty));
        return respuesta;
    }

    @PutMapping(path = {"updateTipoDocumento/{code}/{name}"})
    public String retornarUpdateTipoDocumento(@PathVariable("code") int code, @PathVariable("name") String name) {
        return "Actualizando Tipo de Documento con codigo \"" + code + "\" a nuevo nombre \"" + name + "\".";
    }

    @DeleteMapping(path = {"deleteTipoDocumento/{code}/{exist}"})
    public String retornarDeleteTipoDocumento(@PathVariable("code") int code, @PathVariable("exist") String exist) {
        String respuesta = st.deleteTDocumento(code, Boolean.parseBoolean(exist));
        return respuesta;
    }
}
