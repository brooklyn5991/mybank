package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class TieredInterestStrategy implements InterestStrategy{
    // balances below limit get standard rate while above gets premium rate
    private static final BigDecimal LIMIT = new BigDecimal("10000.00");
    private static final BigDecimal BASE_RATE = new BigDecimal("0.02");
    private static final BigDecimal PREMIUM_RATE = new BigDecimal("0.05");

    @Override
    public BigDecimal calculateInterest(BigDecimal balance) {
        if (balance.compareTo(BigDecimal.ZERO) <= 0) {
            return BigDecimal.ZERO.setScale(2, RoundingMode.HALF_EVEN);
        } else if (balance.compareTo(LIMIT) <= 0) {
            return balance.multiply(BASE_RATE).setScale(2, RoundingMode.HALF_EVEN);
        } else  {
            BigDecimal interest1 = LIMIT.multiply(BASE_RATE);

            BigDecimal interest2 = balance.subtract(LIMIT).multiply(PREMIUM_RATE);

            balance = interest1.add(interest2);
            return balance.setScale(2, RoundingMode.HALF_EVEN);
        }
    }
}
