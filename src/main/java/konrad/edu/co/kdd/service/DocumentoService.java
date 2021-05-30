package konrad.edu.co.kdd.service;

import java.util.ArrayList;
import java.util.Iterator;
import konrad.edu.co.kdd.entity.Documento;
import konrad.edu.co.kdd.repository.DocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Grupo 2
 */
@Service

public class DocumentoService {

    @Autowired
    private DocumentoRepository documentoRepository;

    public ArrayList<Documento> readDocumento() {
        ArrayList<Documento> documento = new ArrayList<>();
        Iterable rec1;
        rec1 = documentoRepository.findAll();
        Iterator<Documento> rec2 = rec1.iterator();
        while (rec2.hasNext()) {
            Documento Documento;
            Documento = rec2.next();
            documento.add(Documento);
        }
        return documento;
    }

}
