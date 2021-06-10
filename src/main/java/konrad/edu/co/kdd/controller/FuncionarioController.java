package konrad.edu.co.kdd.controller;

import konrad.edu.co.kdd.entity.Funcionario;
import konrad.edu.co.kdd.service.FuncionarioService;
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
 * @author grupo2
 */
@RestController
@RequestMapping(path = "funcionario")

public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping(path = "create")
    public @ResponseBody
    ResponseEntity crearFuncionario(@RequestBody Funcionario funcionario) {
        try {
            String clave = funcionario.getContraseña();
            if (clave.length() < 8) {
                return new ResponseEntity("La contraseña debe tener almenos 8 caracteres.", HttpStatus.LENGTH_REQUIRED);
            }
            char car;
            int num = 0, may = 0, min = 0;
            for (int i = 0; i < clave.length(); i++) {
                car = clave.charAt(i);
                if (Character.isDigit(car)) {
                    num++;
                } else if (Character.isUpperCase(car)) {
                    may++;
                } else if (Character.isLowerCase(car)) {
                    min++;
                }
            }
            if (may == 0 || min == 0 || num == 0) {
                return new ResponseEntity("La contraseña debe tener almenos 1 letra en mayuscula, 1 letra en minuscula y un numero.", HttpStatus.LENGTH_REQUIRED);
            }
            funcionarioService.crearFuncionario(funcionario);
            return new ResponseEntity(HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "read")
    public ResponseEntity readFuncionarios() {
        try {
            return new ResponseEntity(funcionarioService.readFuncionario(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path = "update")
    ResponseEntity updateFuncionarios(@RequestBody Funcionario funcionario) {
        try {
            funcionarioService.updateFuncionarios(funcionario);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(path = "delete")
    ResponseEntity deleteFuncionarios(@RequestBody Funcionario funcionario) {
        try {
            funcionarioService.deleteFuncionarios(funcionario);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
