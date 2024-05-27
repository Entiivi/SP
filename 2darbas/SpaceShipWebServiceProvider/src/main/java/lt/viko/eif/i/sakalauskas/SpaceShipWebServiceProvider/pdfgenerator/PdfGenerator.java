package lt.viko.eif.i.sakalauskas.SpaceShipWebServiceProvider.pdfgenerator;

import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.xmlgraphics.util.MimeConstants;

import javax.xml.transform.*;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

public class PdfGenerator {
    public static void generatePdf(InputStream xmlInputStream, InputStream xslInputStream, OutputStream pdfOutputStream) throws Exception {
        // Setup FOP factory
        FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());

        // Create a transformation
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer(new StreamSource(xslInputStream));

        // Setup output stream for PDF
        Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, pdfOutputStream);

        // Perform transformation
        transformer.transform(new StreamSource(xmlInputStream), new SAXResult(fop.getDefaultHandler()));
    }
}
