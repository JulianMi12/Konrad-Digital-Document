package konrad.edu.co.kdd.service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPTable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    @Autowired
    private SendMail sendMail;
    @Autowired
    private FuncionarioService funcionarioService;
    @Autowired
    private AsuntoService asuntoService;

    public void crearDocumento(Documento documento) {
        documentoRepository.save(documento);
        enviarEmail(documento);
    }

    private void enviarEmail(Documento documento) {
        int codDestinatario = documento.getDestino().getIdFuncionario();
        int codAsunto = documento.getAsunto().getIdAsunto();
        String correoDestinatario = funcionarioService.getById(codDestinatario).getCorreo();
        String contenido = "Sr/a. " + funcionarioService.getById(codDestinatario).getApellido() + ".\n\nTiene nueva correspondencia de Konrad Digital Document de parte de \"" + documento.getOrigen() + "\" con asunto \""+asuntoService.getById(codAsunto).getNombre()+"\" para resolver en su buzón de documentos.";
        sendMail.sendMail("correokdd@gmail.com", correoDestinatario, "Nueva Correspondencia", contenido);
    }

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

    public ArrayList<Documento> readDocAsignados(int id) {
        ArrayList<Documento> documento = new ArrayList<>();
        Iterable rec1;
        rec1 = documentoRepository.findAll();
        Iterator<Documento> rec2 = rec1.iterator();
        while (rec2.hasNext()) {
            Documento Documento;
            Documento = rec2.next();
            if (Documento.getDestino().getIdFuncionario() == id) {
                documento.add(Documento);
            }

        }
        return documento;
    }

    public void updateDocumento(Documento documento) {
        documentoRepository.save(documento);
    }

    public void deleteDocumento(Documento documento) {
        documentoRepository.delete(documento);
    }

    public void writePDF(Documento documento) {
        Calendar calendario = Calendar.getInstance();
        int hora, minutos, segundos;
        hora = calendario.get(Calendar.HOUR_OF_DAY);
        minutos = calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND);
        Document document = new Document();
        try {
            String path = new File(".").getCanonicalPath();
            String FILE_NAME = path + "/Reporte_Asuntos_id=" + documento.getNumeroRadicado() + "_" + hora + "-" + minutos + "-" + segundos + ".pdf";
            PdfWriter.getInstance(document, new FileOutputStream(new File(FILE_NAME)));

            System.out.println("");
            document.open();
            Paragraph paragraphHello = new Paragraph();
            paragraphHello.add("Hello iText paragraph!");
            paragraphHello.setAlignment(Element.ALIGN_JUSTIFIED);

            document.add(paragraphHello);

            document.close();
        } catch (IOException ex) {
            Logger.getLogger(DocumentoService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(DocumentoService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
