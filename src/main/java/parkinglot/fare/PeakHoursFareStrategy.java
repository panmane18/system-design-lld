package parkinglot.fare;

import parkinglot.Ticket;
import java.math.BigDecimal;

public class PeakHoursFareStrategy implements FareCalculator {

    private final FareCalculator baseFare;

    public PeakHoursFareStrategy(FareCalculator baseFare) {
        this.baseFare = baseFare;
    }

    @Override
    public BigDecimal calculateFare(Ticket ticket) {
        return baseFare.calculateFare(ticket).multiply(BigDecimal.valueOf(1.5));
    }
}
