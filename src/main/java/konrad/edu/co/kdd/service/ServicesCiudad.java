package konrad.edu.co.kdd.service;

import konrad.edu.co.kdd.entity.Ventanilla;
import konrad.edu.co.kdd.repository.CiudadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Grupo 2
 */
@Service

public class ServicesCiudad {

    @Autowired
    private CiudadRepository ciudadRepository;

    public void crearCiudad(Ventanilla ventanilla) {
        ciudadRepository.save(ventanilla);
    }
}
