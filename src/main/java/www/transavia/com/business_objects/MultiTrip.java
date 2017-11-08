package www.transavia.com.business_objects;

public class MultiTrip {
    private String depatureAirportFirst;
    private String arrivalAirportFirst;
    private String depatureAirportSecond;
    private String arrivalAirportSecond;

    public MultiTrip() {
    }

    public String getDepatureAirportFirst() {
        return depatureAirportFirst;
    }

    public void setDepatureAirportFirst(String depatureAirportFirst) {
        this.depatureAirportFirst = depatureAirportFirst;
    }

    public String getArrivalAirportFirst() {
        return arrivalAirportFirst;
    }

    public void setArrivalAirportFirst(String arrivalAirportFirst) {
        this.arrivalAirportFirst = arrivalAirportFirst;
    }

    public String getDepatureAirportSecond() {
        return depatureAirportSecond;
    }

    public void setDepatureAirportSecond(String depatureAirportSecond) {
        this.depatureAirportSecond = depatureAirportSecond;
    }

    public String getArrivalAirportSecond() {
        return arrivalAirportSecond;
    }

    public void setArrivalAirportSecond(String arrivalAirportSecond) {
        this.arrivalAirportSecond = arrivalAirportSecond;
    }
}
