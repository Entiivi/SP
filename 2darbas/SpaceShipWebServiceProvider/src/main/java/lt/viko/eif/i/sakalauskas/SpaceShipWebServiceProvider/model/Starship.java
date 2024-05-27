package lt.viko.eif.i.sakalauskas.SpaceShipWebServiceProvider.model;

import java.util.List;

public class Starship {
    private String shipName;
    private CrewMember captain;
    private List<CrewMember> crewMember;

    public Starship() {

    }

    public void setShipName(String enterprise) {
    }

    public void setCaptain(CrewMember crewMember) {
    }

    public void setCrewMember(List<CrewMember> crewMembers) {
    }

    public Starship(String shipName, CrewMember captain, List<CrewMember> crewMember) {
        this.shipName = shipName;
        this.captain = captain;
        this.crewMember = crewMember;
    }
}
