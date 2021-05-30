package konrad.edu.co.kdd.controller;

import konrad.edu.co.kdd.service.DocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @GetMapping(path = "read")
    public ResponseEntity readDocumento() {
        try {
            return new ResponseEntity(documentoService.readDocumento(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
