package com.company.projektHipoteczny.model;

import com.company.projektHipoteczny.service.MortgageReference;

import java.math.BigDecimal;

public class Rate {

    //  PUNKT W CZASIE
    private final TimePoint timePoint;
    // NUMER RATY
    private final BigDecimal rateNumber;
    //  KWOTY DOTYCZĄCE RATY
    private final RateAmounts rateAmounts;
    //  WARTOSCI POZOSTALE DOTYCZACE RATY
    private final MortgageResidual mortgageResidual;

    private final MortgageReference mortgageReference;

    public Rate(
            TimePoint timePoint,
            BigDecimal rateNumber,
            RateAmounts rateAmounts,
            MortgageResidual mortgageResidual,
            MortgageReference mortgageReference
    ) {
        this.timePoint = timePoint;
        this.rateNumber = rateNumber;
        this.rateAmounts = rateAmounts;
        this.mortgageResidual = mortgageResidual;
        this.mortgageReference = mortgageReference;
    }


    public TimePoint getTimePoint() {
        return timePoint;
    }

    public BigDecimal getRateNumber() {
        return rateNumber;
    }

    public RateAmounts getRateAmounts() {
        return rateAmounts;
    }

    public MortgageResidual getMortgageResidual() {
        return mortgageResidual;
    }

    public MortgageReference getMortgageReference() {
        return mortgageReference;
    }
}
