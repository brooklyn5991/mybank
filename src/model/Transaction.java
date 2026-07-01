package model;

import java.math.BigDecimal;

public record Transaction(String transactionId, BigDecimal amount, String type) {
    public Transaction {
        if (transactionId == null || amount == null || type == null) {
            throw new IllegalArgumentException("values cannot be null");
        }
    }
}
