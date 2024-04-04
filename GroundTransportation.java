
public class GroundTransportation extends Transport {
    private String licensePlate;

    public GroundTransportation(String licensePlate) {
        super();
        this.licensePlate = licensePlate;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
}
