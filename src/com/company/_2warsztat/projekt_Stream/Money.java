package com.company._2warsztat.projekt_Stream;

import java.math.BigDecimal;

public class Money {
    private final BigDecimal value;
    private final Currency currency;

    public Money(BigDecimal value, Currency currency) {
        this.value = value;
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Money{" +
                "value=" + value +
                ", currency=" + currency +
                '}';
    }

    public BigDecimal getValue() {
        return value;
    }

    public Currency getCurrency() {
        return currency;
    }

    public enum Currency {
        PLN,
        EUR
    }
}
