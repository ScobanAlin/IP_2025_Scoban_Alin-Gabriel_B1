import java.util.ArrayList;

public class Client extends User {                     /// MADE BY HUMAN :))
    private String paymentMethod;
    private ArrayList<RideRequest> rides = new ArrayList<>();

    public Client(String name, String username, String paymentMethod) {
        super(name, username);
        this.paymentMethod = paymentMethod;
    }

    public void addNewRide(RideRequest newRide) {
        this.rides.add(newRide);
    }

    public void removeRide(RideRequest ride) {
        this.rides.remove(ride);
    }

    public ArrayList<RideRequest> getRides() {
        return rides;
    }

    public void makeRideRequest(String pickupLocaton, String dropOffLocation) {
        Driver driver = getClosestDriver();
        RideRequest newRide = new RideRequest(this, driver, pickupLocaton, dropOffLocation);
        newRide.setRideStatus(RIDESTATUS.PICKUP);
        newRide.setPaymentMethod(this.paymentMethod);
        addNewRide(newRide);
    }

    public Driver getClosestDriver() {
        Driver closestDriver = new Driver("Dan", "DanSmecherul", "Dacia Logan");   ///E doar unul random hardcodat, :)) nu avem API pt closest driver
        return closestDriver;
    }

    public void updateName(String name) {
        this.setName(name);
    }

    public void updatePasword(String password) {
        this.setPassword(password);
    }
}
