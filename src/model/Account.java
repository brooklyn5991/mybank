package model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

/* I used Record here for account safety */
public record Account(String accountId, BigDecimal balance, List<Transaction> history, InterestStrategy interestStrategy) {
    // for data validation and strict copying
    public Account {
        if (accountId == null || balance == null || interestStrategy == null) {
            throw new IllegalArgumentException("fields cant be null");
        }

        // defence copied to stop external mutation
        if (history != null) {
            history = List.copyOf(history);
        } else {
            history = List.of();
        }
    }

    public BigDecimal calculateAppliedInterest()
    {
        return interestStrategy.calculateInterest(this.balance);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Account other)) return false;

        return this.accountId.equals(other.accountId);
    }

    public int hashCode() {
        return java.util.Objects.hash(this.accountId);
    }
}
