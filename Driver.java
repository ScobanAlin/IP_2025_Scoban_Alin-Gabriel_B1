public class Driver extends User {                  /// ///MADE WITH AI

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
