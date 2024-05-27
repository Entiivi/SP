package lt.viko.eif.i.sakalauskas.SpaceShipWebServiceProvider.controller;

import lt.viko.eif.i.sakalauskas.SpaceShipWebServiceProvider.Config.WebServiceConfig;
import lt.viko.eif.i.sakalauskas.SpaceShipWebServiceProvider.pdfgenerator.PdfGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.WsdlDefinitionHandlerAdapter;
import org.springframework.xml.transform.StringResult;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
@RequestMapping("/starship")
@EnableWs
@Import(WebServiceConfig.class)
public class StarshipWebServiceController extends WsConfigurerAdapter {

    @Autowired
    private DefaultWsdl11Definition starshipWsdl;


    @GetMapping("/pdf")
    @ResponseBody
    public ResponseEntity<byte[]> getPdf() {
        try {
            // Load XML file as a stream
            InputStream xmlInputStream = new FileInputStream("ship.xml");
            if (xmlInputStream == null) {
                System.err.println("XML file not found.");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
            // Load XSL file as a stream
            InputStream xslInputStream = new FileInputStream("shipToPdf.xsl");
            if (xslInputStream == null) {
                System.err.println("XSL file not found.");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }

            // Setup output stream for PDF
            ByteArrayOutputStream pdfStream = new ByteArrayOutputStream();

            // Perform the transformation
            PdfGenerator.generatePdf(xmlInputStream, xslInputStream, pdfStream);

            // Set response headers
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("filename", "Starship.pdf");

            // Return PDF content as response
            return ResponseEntity.ok()
                    .headers(headers)
                    .body(pdfStream.toByteArray());
        } catch (TransformerException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/test")
    @ResponseBody
    public String home() {
        return "Welcome to SpaceShip Web Service!";
    }

    @GetMapping("/wsdl")
    @ResponseBody
    public String getWsdl() {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            StringResult result = new StringResult();
            transformer.transform(starshipWsdl.getSource(), result);
            return result.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to generate WSDL";
        }
    }

}
