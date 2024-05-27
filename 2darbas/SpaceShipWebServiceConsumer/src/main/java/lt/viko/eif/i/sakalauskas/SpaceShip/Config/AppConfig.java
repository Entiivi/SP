package lt.viko.eif.i.sakalauskas.SpaceShip.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

@Configuration
public class AppConfig {

    @Bean
    public WebServiceTemplate webServiceTemplate() {
        WebServiceTemplate template = new WebServiceTemplate();
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("lt.viko.eif.i.sakalauskas.SpaceShip.model"); // Set the package of your model classes
        template.setMarshaller(marshaller);
        template.setUnmarshaller(marshaller);
        return template;
    }
}