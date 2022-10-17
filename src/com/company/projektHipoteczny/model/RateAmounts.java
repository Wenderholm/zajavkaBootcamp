package com.company.projektHipoteczny.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RateAmounts {
//     kwota raty
    private final BigDecimal rateAmount;
//     kowta odsetek
     private final BigDecimal interestAmount;
//     kwota kapitału
     private final BigDecimal capitalAmount;

     private final Overpayment overpayment;

    public RateAmounts(
            BigDecimal rateAmount,
            BigDecimal interestAmount,
            BigDecimal capitalAmount,
            Overpayment overpayment
    ) {
        this.rateAmount = rateAmount;
        this.interestAmount = interestAmount;
        this.capitalAmount = capitalAmount;
        this.overpayment = overpayment;
    }


    public BigDecimal getRateAmount() {
        return rateAmount.setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getInterestAmount() {
        return interestAmount.setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getCapitalAmount() {
        return capitalAmount.setScale(2, RoundingMode.HALF_UP);
    }

    public Overpayment getOverpayment() {
        return overpayment;
    }


}
