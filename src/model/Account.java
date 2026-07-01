package model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public record Account(String accountId, BigDecimal balance, List<Transaction> history) {
    public Account {
        if (accountId == null || balance == null) {
            throw new IllegalArgumentException("fields cant be null");
        }

        if (history != null) {
            history = List.copyOf(history);
        } else {
            history = List.of();
        }
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
