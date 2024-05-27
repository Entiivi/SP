package lt.viko.eif.i.sakalauskas.SpaceShip.Client;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class StarshipClient {

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        // Set the request headers
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_PDF));

        // Send the request to generate PDF
        ResponseEntity<byte[]> response = restTemplate.exchange("http://localhost:9090/starship/pdf", HttpMethod.GET, new HttpEntity<>(headers), byte[].class);

        // Check if the response is successful
        if (response.getStatusCode() == HttpStatus.OK) {
            try {
                // Save the PDF to a file
                FileOutputStream fos = new FileOutputStream("Starship.pdf");
                fos.write(response.getBody());
                fos.close();
                System.out.println("PDF saved successfully.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Failed to generate PDF. Status code: " + response.getStatusCode());
        }
    }
}
