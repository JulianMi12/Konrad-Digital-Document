package konrad.edu.co.rest1.service;

import java.util.ArrayList;
import java.util.Iterator;
import konrad.edu.co.rest1.entity.TipoDocumento;
import konrad.edu.co.rest1.repository.TipoDocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Team 2
 */
@Service

public class ServicesTipoDocumento {

    @Autowired
    private TipoDocumentoRepository tDocumentoRepository;

    public void crearTipoDocumento(TipoDocumento tipoDocumento) {
        tDocumentoRepository.save(tipoDocumento);
    }

    public ArrayList<TipoDocumento> readTipoDocumento() {
        ArrayList<TipoDocumento> tipoDocumentos = new ArrayList<>();
        Iterable rec1;
        rec1 = tDocumentoRepository.findAll();
        Iterator<TipoDocumento> rec2 = rec1.iterator();
        while(rec2.hasNext()){
            TipoDocumento tDocumento;
            tDocumento = rec2.next();
            tipoDocumentos.add(tDocumento);
        }
        return tipoDocumentos;
    }

    public void updateTipoDocumento(TipoDocumento tipoDocumento) {
        tDocumentoRepository.save(tipoDocumento);
    }

    public void deleteTipoDocumento(TipoDocumento tipoDocumento) {
        tDocumentoRepository.delete(tipoDocumento);
    }
}
