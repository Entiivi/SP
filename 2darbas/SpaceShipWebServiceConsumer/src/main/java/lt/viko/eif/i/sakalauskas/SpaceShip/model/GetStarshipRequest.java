package lt.viko.eif.i.sakalauskas.SpaceShip.model;

public class GetStarshipRequest {
    // Define properties representing input parameters for the getStarship operation
    private String shipName;

    // Constructor, getters, and setters
    // Constructor
    public GetStarshipRequest() {
    }

    // Getter and setter for shipName
    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }
}
