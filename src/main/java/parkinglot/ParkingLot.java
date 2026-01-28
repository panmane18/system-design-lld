package parkinglot;

import parkinglot.fare.FareCalculator;
import parkinglot.spot.ParkingSpot;
import parkinglot.vehicle.Vehicle;

import java.math.BigDecimal;

public class ParkingLot {

    private final ParkingManager parkingManager;
    private final FareCalculator fareCalculator;

    public ParkingLot(ParkingManager parkingManager, FareCalculator fareCalculator) {
        this.parkingManager = parkingManager;
        this.fareCalculator = fareCalculator;
    }

    public Ticket enter(Vehicle vehicle) {
        ParkingSpot spot = parkingManager.park(vehicle);
        if (spot == null) {
            System.out.println("No spot available for vehicle " + vehicle.getLicensePlate());
            return null;
        }
        System.out.println("Vehicle parked at spot " + spot.getSpotNumber());
        return new Ticket(vehicle, spot);
    }

    public BigDecimal exit(Ticket ticket) {
        ticket.exit();
        parkingManager.unpark(ticket.getVehicle());
        return fareCalculator.calculateFare(ticket);
    }
}
