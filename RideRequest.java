public class RideRequest {                             /// /MADE BY HUMAN :))
    private Client client;
    private Driver driver;
    private String pickupLocation;
    private String dropOffLocation;
    private String paymentMethod;
    private RIDESTATUS rideStatus;

    public RideRequest(Client client, Driver driver, String pickupLocation, String dropOffLocation) {
        this.client = client;
        this.driver = driver;
        this.pickupLocation = pickupLocation;
        this.dropOffLocation = dropOffLocation;
        this.rideStatus = RIDESTATUS.PICKUP;
    }

    public void setRideStatus(RIDESTATUS rideStatus) {
        this.rideStatus = rideStatus;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public RIDESTATUS getRideStatus() {
        return rideStatus;
    }

    public String getDropOffLocation() {
        return dropOffLocation;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }
}
