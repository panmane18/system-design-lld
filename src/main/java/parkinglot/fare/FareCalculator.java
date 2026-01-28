package parkinglot.fare;

import parkinglot.Ticket;
import java.math.BigDecimal;

public interface FareCalculator {
    BigDecimal calculateFare(Ticket ticket);
}
