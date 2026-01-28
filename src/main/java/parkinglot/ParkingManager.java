package parkinglot;

import parkinglot.spot.ParkingSpot;
import parkinglot.vehicle.Vehicle;
import parkinglot.vehicle.VehicleSize;

import java.util.*;

public class ParkingManager {

    private final Map<VehicleSize, Queue<ParkingSpot>> availableSpots = new HashMap<>();
    private final Map<Vehicle, ParkingSpot> occupiedSpots = new HashMap<>();

    public ParkingManager(List<ParkingSpot> spots) {
        for (ParkingSpot spot : spots) {
            availableSpots
                    .computeIfAbsent(spot.getSize(), k -> new LinkedList<>())
                    .add(spot);
        }
    }

    public ParkingSpot park(Vehicle vehicle) {
        Queue<ParkingSpot> spots = availableSpots.get(vehicle.getSize());
        if (spots == null || spots.isEmpty()) return null;

        ParkingSpot spot = spots.poll();
        spot.occupy(vehicle);
        occupiedSpots.put(vehicle, spot);
        return spot;
    }

    public void unpark(Vehicle vehicle) {
        ParkingSpot spot = occupiedSpots.remove(vehicle);
        if (spot != null) {
            spot.vacate();
            availableSpots.get(spot.getSize()).offer(spot);
        }
    }
}
