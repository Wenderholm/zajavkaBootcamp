package com.company.projektHipoteczny.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MortgageResidual {
//    pozostala kwota do splaty
    private final BigDecimal amount;
//pozostaly czas do splaty
    private final BigDecimal duration;


    public MortgageResidual(BigDecimal amount, BigDecimal duration) {
        this.amount = amount;
        this.duration = duration;
    }


    public BigDecimal getAmount() {
        return amount.setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getDuration() {
        return duration;
    }



}
