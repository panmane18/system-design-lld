package parkinglot;

import parkinglot.spot.ParkingSpot;
import parkinglot.vehicle.Vehicle;

import java.time.Duration;
import java.time.LocalDateTime;

public class Ticket {

    private final Vehicle vehicle;
    private final ParkingSpot spot;
    private final LocalDateTime entryTime;
    private LocalDateTime exitTime;

    public Ticket(Vehicle vehicle, ParkingSpot spot) {
        this.vehicle = vehicle;
        this.spot = spot;
        this.entryTime = LocalDateTime.now();
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getSpot() {
        return spot;
    }

    public void exit() {
        this.exitTime = LocalDateTime.now();
    }

    public long getDurationInHours() {
        return Duration.between(entryTime, exitTime).toHours() + 1;
    }
}
