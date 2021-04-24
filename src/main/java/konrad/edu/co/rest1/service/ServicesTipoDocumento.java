package konrad.edu.co.rest1.service;

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

    public TipoDocumento readTipoDocumento() {
        return tDocumentoRepository.findById(1).get();
    }

    public void updateTipoDocumento(TipoDocumento tipoDocumento) {
        tDocumentoRepository.save(tipoDocumento);
    }

    public void deleteTipoDocumento(TipoDocumento tipoDocumento) {
        tDocumentoRepository.delete(tipoDocumento);
    }
}
