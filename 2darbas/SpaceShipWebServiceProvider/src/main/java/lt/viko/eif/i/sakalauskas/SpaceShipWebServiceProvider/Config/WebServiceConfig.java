package lt.viko.eif.i.sakalauskas.SpaceShipWebServiceProvider.Config;
import lt.viko.eif.i.sakalauskas.SpaceShipWebServiceProvider.services.StarShipClientServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.client.RestTemplate;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;


@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {


    @Bean
    public StarShipClientServiceImpl starShipClientService() {

        RestTemplate restTemplate = new RestTemplate();

        return new StarShipClientServiceImpl(restTemplate);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean(name = "starship")
    public DefaultWsdl11Definition starshipWsdl(XsdSchema starshipSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("StarshipPort");
        wsdl11Definition.setLocationUri("/starship");
        wsdl11Definition.setTargetNamespace("http://viko.lt/eif/i/sakalauskas/SpaceShipWebServiceProvider");
        wsdl11Definition.setSchema(starshipSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema starshipSchema() {
        return new SimpleXsdSchema(new ClassPathResource("ship.xsd"));
    }

}
