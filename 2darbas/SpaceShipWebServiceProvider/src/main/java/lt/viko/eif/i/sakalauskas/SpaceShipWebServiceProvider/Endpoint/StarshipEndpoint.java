package lt.viko.eif.i.sakalauskas.SpaceShipWebServiceProvider.Endpoint;

import lt.viko.eif.i.sakalauskas.SpaceShipWebServiceProvider.model.CrewMember;
import lt.viko.eif.i.sakalauskas.SpaceShipWebServiceProvider.model.Starship;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import java.util.List;

@Endpoint
public class StarshipEndpoint {
    private static final String NAMESPACE_URI = "http://viko.lt/eif/i/sakalauskas/SpaceShipWebServiceProvider";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getStarshipRequest")
    @ResponsePayload
    public Starship getStarship() {
        // Here you would implement the logic to fetch the starship details
        List<CrewMember> crewMembers = new ArrayList<>();
        crewMembers.add(new CrewMember("James T. Kirk", "12345", "Commanding Officer", "Exploring new worlds"));
        crewMembers.add(new CrewMember("Spock", "23456", "Science Officer", "Logic and exploration"));
        // and return the Starship object
       Starship spaceship = new Starship();
        spaceship.setShipName("Enterprise");
        spaceship.setCaptain(new CrewMember("James T. Kirk", "12345", "Commanding Officer", "Exploring new worlds"));
        spaceship.setCrewMember(crewMembers);

        return new Starship();
    }

}
