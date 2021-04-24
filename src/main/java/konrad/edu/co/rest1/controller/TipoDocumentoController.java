package konrad.edu.co.rest1.controller;

import konrad.edu.co.rest1.entity.TipoDocumento;
import konrad.edu.co.rest1.service.ServicesTipoDocumento;
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
@RequestMapping(path = "t_documento")

public class TipoDocumentoController {

    @Autowired
    private ServicesTipoDocumento tipoDocumentoService;

    @PostMapping(path = "crear")
    public @ResponseBody
    ResponseEntity crearCiudad(@RequestBody TipoDocumento tDocumento) {
        try {
            tipoDocumentoService.crearTipoDocumento(tDocumento);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "read")
    public ResponseEntity readTipoDocumento() {
        try {
            TipoDocumento tipoDocumento = tipoDocumentoService.readTipoDocumento();
            return new ResponseEntity(tipoDocumento, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path = "update")
    ResponseEntity updateTipoDocumento(@RequestBody TipoDocumento tipoDocumento) {
        try {
            tipoDocumentoService.updateTipoDocumento(tipoDocumento);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(path = "delete")
    ResponseEntity deleteTipoDocumento(@RequestBody TipoDocumento tipoDocumento) {
        try {
            tipoDocumentoService.deleteTipoDocumento(tipoDocumento);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
