package konrad.edu.co.kdd.service;

import konrad.edu.co.kdd.entity.Ventanilla;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import konrad.edu.co.kdd.repository.VentanillaRepository;

/**
 *
 * @author Grupo 2
 */
@Service

public class VentanillaService {

    @Autowired
    private VentanillaRepository ventanillaRepository;

    public void crearUsuario(Ventanilla ventanilla) {
        ventanillaRepository.save(ventanilla);
    }
}
