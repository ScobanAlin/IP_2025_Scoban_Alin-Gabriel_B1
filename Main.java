import java.util.ArrayList;

public class Main {                 /// MADE WITH AI
    public static void main(String[] args) {
        // Creăm un client și un șofer
        Client client = new Client("Alex", "alex123", "Credit Card");
        Driver driver = new Driver("Mihai", "mihai456", "BMW");

        // Clientul face o solicitare de cursă
        client.makeRideRequest("Strada 1", "Strada 2");

        // Afișăm lista de curse a clientului (ar trebui să aibă acum o cursă în proces)
        System.out.println("Curse ale clientului înainte de a începe cursa:");
        for (RideRequest ride : client.getRides()) {
            System.out.println(ride.getPickupLocation() + " -> " + ride.getDropOffLocation() + " | Status: " + ride.getRideStatus());
        }

        // Șoferul acceptă cursa (începe cursa)
        RideRequest ride = client.getRides().get(0);  // Cursa care tocmai a fost adăugată
        driver.startRide(ride);

        // Afișăm din nou lista de curse a clientului
        System.out.println("\nCurse ale clientului după ce șoferul începe cursa:");
        for (RideRequest r : client.getRides()) {
            System.out.println(r.getPickupLocation() + " -> " + r.getDropOffLocation() + " | Status: " + r.getRideStatus());
        }

        // Șoferul finalizează cursa
        driver.completeRide(ride);

        // Afișăm lista de curse a clientului după finalizarea cursei
        System.out.println("\nCurse ale clientului după ce șoferul finalizează cursa:");
        for (RideRequest r : client.getRides()) {
            System.out.println(r.getPickupLocation() + " -> " + r.getDropOffLocation() + " | Status: " + r.getRideStatus());
        }

        // Șoferul refuză o altă cursă
        RideRequest anotherRide = new RideRequest(client, driver, "Strada 3", "Strada 4");
        driver.declineRide(anotherRide, client);

        // Afișăm lista de curse a clientului după ce șoferul refuză cursa
        System.out.println("\nCurse ale clientului după ce șoferul refuză o cursă:");
        for (RideRequest r : client.getRides()) {
            System.out.println(r.getPickupLocation() + " -> " + r.getDropOffLocation() + " | Status: " + r.getRideStatus());
        }
    }
}

enum RIDESTATUS {
    PICKUP,
    DRIVING,
    DONE,
}

abstract class User {                           /// /MADE BY HUMAN
    private String name;
    private String username;
    private String password;

    public User(String name, String username) {
        this.name = name;
        this.username = username;
        this.password = null;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}

class Driver extends User {                  /// ///MADE WITH AI

private String car;

    public Driver(String name, String username, String car) {
        super(name, username);
        this.car = car;
    }

    // Metoda pentru a începe o cursă
    public void startRide(RideRequest ride) {
        if (ride != null && ride.getRideStatus() == RIDESTATUS.PICKUP) {
            ride.setRideStatus(RIDESTATUS.DRIVING);
            System.out.println("Cursa inceputa: " + ride.getPickupLocation() + " -> " + ride.getDropOffLocation());
        }
    }

    // Metoda pentru a finaliza o cursă
    public void completeRide(RideRequest ride) {
        if (ride != null && (ride.getRideStatus() == RIDESTATUS.PICKUP || ride.getRideStatus() == RIDESTATUS.DRIVING)) {
            ride.setRideStatus(RIDESTATUS.DONE);
            System.out.println("Cursa finalizata: " + ride.getPickupLocation() + " -> " + ride.getDropOffLocation());
        }
    }

    // Metoda pentru a refuza o cursă
    public void declineRide(RideRequest ride, Client client) {
        if (ride != null && ride.getRideStatus() == RIDESTATUS.PICKUP) {
            ride.setRideStatus(RIDESTATUS.DONE); // Sau poți adăuga un status `DECLINED` în enumul RIDESTATUS
            client.removeRide(ride); // Elimina cursa din lista clientului
            System.out.println("Cursa refuzata: " + ride.getPickupLocation() + " -> " + ride.getDropOffLocation());
        }
    }
}


class Client extends User {                     /// MADE BY HUMAN :))
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


class RideRequest {                             /// /MADE BY HUMAN :))
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
