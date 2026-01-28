package parkinglot.fare;

import parkinglot.Ticket;
import parkinglot.vehicle.VehicleSize;

import java.math.BigDecimal;

public class BaseFareStrategy implements FareCalculator {

    @Override
    public BigDecimal calculateFare(Ticket ticket) {
        long hours = ticket.getDurationInHours();

        if (ticket.getVehicle().getSize() == VehicleSize.SMALL)
            return BigDecimal.valueOf(10 * hours);

        if (ticket.getVehicle().getSize() == VehicleSize.MEDIUM)
            return BigDecimal.valueOf(20 * hours);

        return BigDecimal.valueOf(30 * hours);
    }
}
