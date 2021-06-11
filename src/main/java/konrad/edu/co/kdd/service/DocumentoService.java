package konrad.edu.co.kdd.service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import konrad.edu.co.kdd.entity.Asunto;
import konrad.edu.co.kdd.entity.Documento;
import konrad.edu.co.kdd.entity.Funcionario;
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

    public Documento crearDocumento(Documento documento) {
        documentoRepository.save(documento);
        enviarEmail(documento);
        return documento;
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

    private void enviarEmail(Documento documento) {
        int codDestinatario = documento.getDestino().getIdFuncionario();
        int codAsunto = documento.getAsunto().getIdAsunto();
        String correoDestinatario = funcionarioService.getById(codDestinatario).getCorreo();
        String contenido = "Sr/a. "+funcionarioService.getById(codDestinatario).getApellido()+".\n\nTiene nueva correspondencia de Konrad Digital Document de parte de \""+documento.getOrigen()+"\" con asunto \""+asuntoService.getById(codAsunto).getNombre()+"\" para resolver en su buzón de documentos.";
        sendMail.sendMail("konradMensajes@gmail.com", correoDestinatario, "Nueva Correspondencia", contenido);
    }

    public static void main(String[] args) {
        writePDF();
    }

    private static void writePDF() {
        Document document = new Document();

        try {
            String path = new File(".").getCanonicalPath();
            String FILE_NAME = path + "/itext-test-file.pdf";

            PdfWriter.getInstance(document, new FileOutputStream(new File(FILE_NAME)));

            document.open();

            Paragraph paragraphHello = new Paragraph();
            paragraphHello.add("Hello iText paragraph!");
            paragraphHello.setAlignment(Element.ALIGN_JUSTIFIED);

            document.add(paragraphHello);

            Paragraph paragraphLorem = new Paragraph();
            paragraphLorem.add("Lorem ipsum dolor sit amet, consectetur adipiscing elit."
                    + "Maecenas finibus fringilla turpis, vitae fringilla justo."
                    + "Sed imperdiet purus quis tellus molestie, et finibus risus placerat."
                    + "Donec convallis eget felis vitae interdum. Praesent varius risus et dictum hendrerit."
                    + "Aenean eu semper nunc. Aenean posuere viverra orci in hendrerit. Aenean dui purus, eleifend nec tellus vitae,"
                    + " pretium dignissim ex. Aliquam erat volutpat. ");

            java.util.List<Element> paragraphList = new ArrayList<>();

            paragraphList = paragraphLorem.breakUp();

            Font f = new Font();
            f.setFamily(FontFamily.COURIER.name());
            f.setStyle(Font.BOLDITALIC);
            f.setSize(8);

            Paragraph p3 = new Paragraph();
            p3.setFont(f);
            p3.addAll(paragraphList);
            p3.add("TEST LOREM IPSUM DOLOR SIT AMET CONSECTETUR ADIPISCING ELIT!");

            document.add(paragraphLorem);
            document.add(p3);
            document.close();

        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void updateDocumento(Documento documento) {
        documentoRepository.save(documento);
    }

    public void deleteDocumento(Documento documento) {
        documentoRepository.delete(documento);
    }

}
