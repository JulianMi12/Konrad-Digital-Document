package konrad.edu.co.kdd.service;

import java.util.ArrayList;
import java.util.Iterator;
import konrad.edu.co.kdd.entity.Documento;
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

    public ArrayList<Ventanilla> readUsuario() {
        ArrayList<Ventanilla> ventanilla = new ArrayList<>();
        Iterable rec1;
        rec1 = ventanillaRepository.findAll();
        Iterator<Ventanilla> rec2 = rec1.iterator();
        while (rec2.hasNext()) {
            Ventanilla Ventanilla;
            Ventanilla = rec2.next();
            ventanilla.add(Ventanilla);
        }
        return ventanilla;
    }

    public void updateUsuario(Ventanilla ventanilla) {
        ventanillaRepository.save(ventanilla);
    }

    public void deleteUsuario(Ventanilla ventanilla) {
        ventanillaRepository.delete(ventanilla);
    }
}
