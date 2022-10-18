package com.company.projektHipoteczny.service;

import com.company.projektHipoteczny.model.InputData;
import com.company.projektHipoteczny.model.MortgageResidual;
import com.company.projektHipoteczny.model.Rate;
import com.company.projektHipoteczny.model.RateAmounts;

import java.math.BigDecimal;

import static com.company.projektHipoteczny.service.CalculateUtils.calculateResidualAmount;


public class ResidualCalculationServiceImpl implements ResidualCalculationService {
    @Override
    public MortgageResidual calculate(RateAmounts rateAmounts, InputData inputData) {
//        kwota poczatkowa kredytu inputData.getAmount() odejmujemy od niej kwote kapitału jaką bedziemy od niej spłacać
//        rateAmounts.getCapitalAmount()
        BigDecimal residualAmount = calculateResidualAmount( inputData.getAmount(),rateAmounts);
        BigDecimal residualDuration = inputData.getMonthDuration().subtract(BigDecimal.ONE);

        return new MortgageResidual(residualAmount,residualDuration);
    }

    @Override
    public MortgageResidual calculate(RateAmounts rateAmounts, Rate previousRate) {
        MortgageResidual residual = previousRate.getMortgageResidual();
//        .max(BigDecimal.ZERO) -> ustawia nam jeżeli rata zejdzie poniżej zera to ustawi nam 0
        BigDecimal residualAmount = calculateResidualAmount(residual.getAmount(),rateAmounts);;
        BigDecimal residualDuration = residual.getDuration().subtract(BigDecimal.ONE);

        return new MortgageResidual(residualAmount,residualDuration);
    }


}
