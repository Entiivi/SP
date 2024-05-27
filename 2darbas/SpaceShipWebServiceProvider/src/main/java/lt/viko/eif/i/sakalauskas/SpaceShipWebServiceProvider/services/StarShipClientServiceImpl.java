package lt.viko.eif.i.sakalauskas.SpaceShipWebServiceProvider.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StarShipClientServiceImpl implements StarShipClientService {
    private final String serviceUrl = "http://localhost:9090/starship/pdf";

    private final RestTemplate restTemplate;

    @Autowired
    public StarShipClientServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public byte[] getPdf() {
        try {
            ResponseEntity<byte[]> response = restTemplate.getForEntity(serviceUrl, byte[].class);
            if (response.getStatusCode() == HttpStatus.OK) {
                return response.getBody();
            } else {
                // Handle non-successful response (e.g., log error, throw exception)
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception for debugging purposes
            // Handle exception (e.g., log error, throw custom exception)
            return null;
        }
    }
}
