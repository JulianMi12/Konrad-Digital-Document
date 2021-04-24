package konrad.edu.co.rest1.service;

import konrad.edu.co.rest1.entity.Ciudad;
import konrad.edu.co.rest1.repository.CiudadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Team 2
 */
@Service

public class ServicesCiudad {

    @Autowired
    private CiudadRepository ciudadRepository;

    public void crearCiudad(Ciudad ciudad) {
        ciudadRepository.save(ciudad);
    }

    public Ciudad readCiudad() {
        return ciudadRepository.findById(1).get();

    }

    public void updateCiudad(Ciudad ciudad) {
        ciudadRepository.save(ciudad);
    }

    public void deleteCiudad(Ciudad ciudad) {
        ciudadRepository.delete(ciudad);
    }
}
