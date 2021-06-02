package konrad.edu.co.kdd.controller;

import konrad.edu.co.kdd.entity.Asunto;
import konrad.edu.co.kdd.service.AsuntoService;
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
@RequestMapping(path = "asunto")

public class AsuntoController {

    @Autowired
    private AsuntoService asuntoService;

    @PostMapping(path = "create")
    public @ResponseBody
    ResponseEntity crearAsunto(@RequestBody Asunto asunto) {
        try {
            asuntoService.crearAsunto(asunto);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "read")
    public ResponseEntity readAsunto() {
        try {
            return new ResponseEntity(asuntoService.readAsunto(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path = "update")
    ResponseEntity updateAsunto(@RequestBody Asunto asunto) {
        try {
            asuntoService.updateAsunto(asunto);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(path = "delete")
    ResponseEntity deleteAsunto(@RequestBody Asunto asunto) {
        try {
            asuntoService.deleteAsunto(asunto);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
