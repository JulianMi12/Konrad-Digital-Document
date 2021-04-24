package konrad.edu.co.rest1.service;

import java.util.ArrayList;
import java.util.Iterator;
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

    public ArrayList<Ciudad> readCiudad() {
        ArrayList<Ciudad> ciudades = new ArrayList<>();
        Iterable rec1;
        rec1 = ciudadRepository.findAll();
        Iterator<Ciudad> rec2 = rec1.iterator();
        while(rec2.hasNext()){
            Ciudad ciudad;
            ciudad = rec2.next();
            ciudades.add(ciudad);
        }
        return ciudades;
    }

    public void updateCiudad(Ciudad ciudad) {
        ciudadRepository.save(ciudad);
    }

    public void deleteCiudad(Ciudad ciudad) {
        ciudadRepository.delete(ciudad);
    }
}
