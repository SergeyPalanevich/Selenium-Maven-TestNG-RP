package www.transavia.com.business_objects;

public class Trip {

    private String depatureAirport;
    private String arrivalAirport;

    public Trip() {
    }

    public String getDepatureAirport() {
        return depatureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setDepatureAirport(String depatureAirport) {
        this.depatureAirport = depatureAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }
}
