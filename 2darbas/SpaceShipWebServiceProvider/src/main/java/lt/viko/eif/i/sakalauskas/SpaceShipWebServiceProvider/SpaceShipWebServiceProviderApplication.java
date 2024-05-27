package lt.viko.eif.i.sakalauskas.SpaceShipWebServiceProvider;

import lt.viko.eif.i.sakalauskas.SpaceShipWebServiceProvider.services.StarShipClientServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan(basePackages = {"lt.viko.eif.i.sakalauskas.SpaceShipWebServiceProvider"})
public class SpaceShipWebServiceProviderApplication {

	public static void main(String[] args) {
		// Run the Spring Boot application
		System.setProperty("server.port", "9090");
		SpringApplication app = new SpringApplication(SpaceShipWebServiceProviderApplication.class);
		app.run(args);

		// Specify the address where the web service endpoint will be published
		String address = "http://localhost:9090/starship/";


		// Create an instance of RestTemplate
		RestTemplate restTemplate = new RestTemplate();

		// Create an instance of the SpaceShipClientServiceImpl class with RestTemplate injected
		StarShipClientServiceImpl spaceShipClientService = new StarShipClientServiceImpl(restTemplate);

		try {
			// Output the WSDL URL
			System.out.println("WSDL URL: " + "http://localhost:9090/starship/wsdl");
			System.out.println("PDF Generation : " + "http://localhost:9090/starship/pdf");
			System.out.println("Test : " + "http://localhost:9090/starship/test");
			// Keep the application running until manually terminated
			Thread.sleep(Long.MAX_VALUE);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

