package com.company.projektHipoteczny.service;

import com.company.projektHipoteczny.model.Rate;
import com.company.projektHipoteczny.model.Summary;

import java.math.BigDecimal;
import java.util.List;

public class SummaryServiceFactory {
    public static SummaryService create() {
        return rates -> {
            BigDecimal interestSum = calculate(rates, rate -> rate.getRateAmounts().getInterestAmount());
            BigDecimal provision = calculate(rates, rate -> rate.getRateAmounts().getOverpayment().getProvisionAmount());
            BigDecimal totalLosts = interestSum.add(provision);
            return new Summary(interestSum, provision, totalLosts);
        };

    }

    private static BigDecimal calculate(List<Rate> rates, Function function) {
        BigDecimal sum = BigDecimal.ZERO;
        for (Rate rate : rates) {
            sum = sum.add(function.calculate(rate));
        }
        return sum;
    }
}
