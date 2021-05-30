/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konrad.edu.co.kdd.service;

import java.util.ArrayList;
import java.util.Iterator;
import konrad.edu.co.kdd.entity.Asunto;
import konrad.edu.co.kdd.repository.AsuntoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alvaro
 */
@Service
public class AsuntoService {

    @Autowired
    private AsuntoRepository asuntoRepository;

    public void crearAsunto(Asunto asunto) {
        asuntoRepository.save(asunto);
    }

    public ArrayList<Asunto> readAsunto() {
        ArrayList<Asunto> asuntos = new ArrayList<>();
        Iterable rec1;
        rec1 = asuntoRepository.findAll();
        Iterator<Asunto> rec2 = rec1.iterator();
        while (rec2.hasNext()) {
            Asunto asunto;
            asunto = rec2.next();
            asuntos.add(asunto);
        }
        return asuntos;
    }

    public void updateAsunto(Asunto asunto) {
        asuntoRepository.save(asunto);
    }

    public void deleteAsunto(Asunto asunto) {
        asuntoRepository.delete(asunto);
    }
}
