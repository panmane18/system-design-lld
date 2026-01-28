package parkinglot;

import parkinglot.spot.CompactSpot;
import parkinglot.spot.OversizedSpot;
import parkinglot.spot.ParkingSpot;
import parkinglot.spot.RegularSpot;
import parkinglot.fare.BaseFareStrategy;
import parkinglot.fare.PeakHoursFareStrategy;
import parkinglot.vehicle.Car;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        List<ParkingSpot> spots = Arrays.asList(
                new CompactSpot(1),
                new RegularSpot(2),
                new RegularSpot(3),
                new OversizedSpot(4)
        );

        ParkingManager manager = new ParkingManager(spots);
        ParkingLot parkingLot = new ParkingLot(
                manager,
                new PeakHoursFareStrategy(new BaseFareStrategy())
        );

        Car car = new Car("MH12-AB-1234");

        Ticket ticket = parkingLot.enter(car);
        Thread.sleep(2000); // simulate parking time

        System.out.println("Total Fare: ₹" + parkingLot.exit(ticket));
    }
}
