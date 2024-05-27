package lt.viko.eif.i.sakalauskas.SpaceShip.model;

public class CrewMember {
    private String name;
    private String crewMemberNumber;
    private String responsibility;
    private String interest;

    public CrewMember(String name, String crewMemberNumber, String responsibility, String interest) {
        this.name = name;
        this.crewMemberNumber = crewMemberNumber;
        this.responsibility = responsibility;
        this.interest = interest;
    }
}

