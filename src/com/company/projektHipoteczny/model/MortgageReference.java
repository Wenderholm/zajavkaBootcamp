package com.company.projektHipoteczny.model;

import java.math.BigDecimal;

public class MortgageReference {
//    kwota
    private final BigDecimal referenceAmount;

    private final BigDecimal referenceDuration;

    public MortgageReference(BigDecimal referenceAmount, BigDecimal referenceDuration) {
        this.referenceAmount = referenceAmount;
        this.referenceDuration = referenceDuration;
    }

    public BigDecimal getAmount() {
        return referenceAmount;
    }

    public BigDecimal getDuration() {
        return referenceDuration;
    }
}
