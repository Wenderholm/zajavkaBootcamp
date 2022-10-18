package com.company.projektHipoteczny.service;

import com.company.projektHipoteczny.model.InputData;
import com.company.projektHipoteczny.model.Overpayment;
import com.company.projektHipoteczny.model.Rate;
import com.company.projektHipoteczny.model.RateAmounts;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.company.projektHipoteczny.service.CalculateUtils.calculateInterestAmount;

public class DecreasingAmountCalculationServiceImpl implements DecreasingAmountCalculationService{
    @Override
    public RateAmounts calculate(InputData inputData, Overpayment overpayment) {
        BigDecimal interestPercent = inputData.getInterestPercent();

        BigDecimal residualAmount = inputData.getAmount();
        BigDecimal referenceAmount = inputData.getAmount();
        BigDecimal referenceDuration = inputData.getMonthDuration();

        BigDecimal interestAmount = calculateInterestAmount(residualAmount, interestPercent);
        BigDecimal capitalAmount = calculateCapitalAmount(referenceAmount,referenceDuration, residualAmount);
        BigDecimal rateAmount = capitalAmount.add(interestAmount);


        return new RateAmounts(rateAmount, interestAmount, capitalAmount, overpayment);

    }
    @Override
    public RateAmounts calculate(InputData inputData, Overpayment overpayment, Rate previousRate) {
        BigDecimal interestPercent = inputData.getInterestPercent();

        BigDecimal residualAmount = previousRate.getMortgageResidual().getAmount();
        BigDecimal referenceDuration = previousRate.getMortgageReference().getDuration();
        BigDecimal referenceAmount = previousRate.getMortgageReference().getAmount();

        BigDecimal interestAmount = calculateInterestAmount(residualAmount, interestPercent);
        BigDecimal capitalAmount = calculateCapitalAmount(referenceAmount,referenceDuration, residualAmount);
        BigDecimal rateAmount = capitalAmount.add(interestAmount);


        return new RateAmounts(rateAmount, interestAmount, capitalAmount, overpayment);
    }



    private BigDecimal calculateCapitalAmount(BigDecimal amount, BigDecimal monthDuration, BigDecimal residualAmount) {
//        kowta raty - kowata odsetek
        BigDecimal capitalAmount = amount.divide(monthDuration,50,RoundingMode.HALF_UP);
        if(capitalAmount.compareTo(residualAmount) >= 0){
            return residualAmount;
        }
        return capitalAmount;
    }

}
