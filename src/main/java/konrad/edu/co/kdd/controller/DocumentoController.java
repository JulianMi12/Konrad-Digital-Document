package konrad.edu.co.kdd.controller;

import konrad.edu.co.kdd.entity.Documento;
import konrad.edu.co.kdd.service.DocumentoService;
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
 * @author Grupo 2
 */
@RestController
@RequestMapping(path = "documento")

public class DocumentoController {

    @Autowired
    private DocumentoService documentoService;

    @PostMapping(path = "crear")
    public @ResponseBody
    ResponseEntity crearDocumento(@RequestBody Documento documento) {
        try {
            documentoService.crearDocumento(documento);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "read")
    public ResponseEntity readDocumento() {
        try {
            return new ResponseEntity(documentoService.readDocumento(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "reada")
    public ResponseEntity readDocAsignados() {
        try {
            return new ResponseEntity(documentoService.readDocAsignados(2), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path = "update")
    ResponseEntity updateDocumento(@RequestBody Documento documento) {
        try {
            documentoService.updateDocumento(documento);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(path = "delete")
    ResponseEntity deleteDocumento(@RequestBody Documento documento) {
        try {
            documentoService.deleteDocumento(documento);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
