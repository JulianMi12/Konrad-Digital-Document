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

    public void crearDocumento(Documento documento) {
        documentoRepository.save(documento);

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

    public void writePDF(int id) {
        ArrayList<Documento> documento = readDocAsignados(id);

        Document document = new Document();
        Calendar calendario = Calendar.getInstance();
        int hora, minutos, segundos;
        hora = calendario.get(Calendar.HOUR_OF_DAY);
        minutos = calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND);

        try {
            String path = new File(".").getCanonicalPath();
            String FILE_NAME = path + "/Reporte_Asuntos_id:" + id + hora + "-" + minutos + "-" + segundos + ".pdf";

            PdfWriter.getInstance(document, new FileOutputStream(new File(FILE_NAME)));

            document.open();

            Paragraph paragraphHello = new Paragraph();
            paragraphHello.add("Listado de Reportes");
            paragraphHello.setAlignment(Element.ALIGN_JUSTIFIED);
            document.add(paragraphHello);
            Paragraph paragraphContenido = new Paragraph();

            for (int i = 0; i < documento.size(); i++) {
                Integer nRadicado = documento.get(i).getNumeroRadicado();
                String personaEnvia = documento.get(i).getOrigen();
                String nombreAsunto = documento.get(i).getAsunto().getNombre();
                String fechaRadi = documento.get(i).getFechaRadicado();

                paragraphContenido.add(nRadicado + personaEnvia + nombreAsunto + fechaRadi);

            }

            java.util.List<Element> paragraphList = new ArrayList<>();

            paragraphList = paragraphContenido.breakUp();
            document.add((Element) paragraphList);
            document.close();

        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
