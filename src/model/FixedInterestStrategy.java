package model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FixedInterestStrategy implements InterestStrategy{
    private final BigDecimal rate;

    public FixedInterestStrategy(BigDecimal rate) {
        if (rate.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Interest must be positive");
        }
        this.rate = rate;
    }

    @Override
    public BigDecimal calculateInterest(BigDecimal balance) {
        BigDecimal interest = balance.multiply(rate);

        return interest.setScale(2, RoundingMode.HALF_EVEN);
    }
}
