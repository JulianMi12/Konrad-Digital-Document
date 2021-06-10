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
import java.util.ArrayList;
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

    public static void writePDF() {
        Document document = new Document();

        try {
            String path = new File(".").getCanonicalPath();
            String FILE_NAME = path + "/itext-test-Reporte_Asuntos.pdf";

            PdfWriter.getInstance(document, new FileOutputStream(new File(FILE_NAME)));

            document.open();

            Paragraph paragraphHello = new Paragraph();
            paragraphHello.add("Reporte 1");
            paragraphHello.setAlignment(Element.ALIGN_JUSTIFIED);

            document.add(paragraphHello);

            Paragraph paragraphLorem = new Paragraph();
            paragraphLorem.add("Señores\n"
                    + "\n"
                    + "\n"
                    + "Me dirijo a ustedes respetuosamente para agradecer por la gran oportunidad de crecimiento dentro de la empresa que me han otorgado al ascenderme en dia de ayer a un cargo superior, y por tener en cuenta mi trabajo, esfuerzo y perseverancia para asumir esta nueva posicion y depositar su confianza en mí.\n"
                    + "\n"
                    + "\n"
                    + "Espero seguir siendo parte de este gran equipo de trabajo que se caracteriza por tener un optimo ambiente laboral y las excelentes herramientas que esta empresa me ha ofrecido desde que inicie mis labores aqui, por lo cual extiendo nuevamente mis mas sinceros agradecimientos, deseando muchos éxitos para ustedes también.\n"
                    + "\n"
                    + "\n"
                    + "Cordialmente,\n");

            java.util.List<Element> paragraphList = new ArrayList<>();

            paragraphList = paragraphLorem.breakUp();

            Font f = new Font();
            f.setFamily(FontFamily.COURIER.name());
            f.setStyle(Font.BOLDITALIC);
            f.setSize(8);

            Paragraph p3 = new Paragraph();
            p3.setFont(f);
            p3.addAll(paragraphList);
            p3.add("Jhonatan Calderón");

            document.add(p3);
            document.close();

        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
