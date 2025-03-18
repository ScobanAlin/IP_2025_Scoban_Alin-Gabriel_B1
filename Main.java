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


