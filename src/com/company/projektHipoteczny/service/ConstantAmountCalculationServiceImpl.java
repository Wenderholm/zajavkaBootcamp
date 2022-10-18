package com.company.projektHipoteczny.service;

import com.company.projektHipoteczny.model.InputData;
import com.company.projektHipoteczny.model.Overpayment;
import com.company.projektHipoteczny.model.Rate;
import com.company.projektHipoteczny.model.RateAmounts;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.company.projektHipoteczny.service.CalculateUtils.calculateInterestAmount;


public class ConstantAmountCalculationServiceImpl implements ConstantAmountCalculationService {

    @Override
    public RateAmounts calculate(InputData inputData, Overpayment overpayment) {
        BigDecimal interestPercent = inputData.getInterestPercent();
        BigDecimal q = calculateQ(interestPercent);

        BigDecimal residualAmount = inputData.getAmount();
        BigDecimal referenceAmount = inputData.getAmount();
        BigDecimal referenceDuration = inputData.getMonthDuration();


        BigDecimal interestAmount = calculateInterestAmount(residualAmount, interestPercent);
        BigDecimal rateAmount = calculateConstantRateAmount(
                q, referenceAmount, referenceDuration,interestAmount,residualAmount);
        BigDecimal capitalAmount =  calculateCapitalAmount(rateAmount, interestAmount, residualAmount);
        return new RateAmounts(rateAmount, interestAmount, capitalAmount, overpayment);

    }
    @Override
    public RateAmounts calculate(InputData inputData, Overpayment overpayment, Rate previousRate) {
        BigDecimal interestPercent = inputData.getInterestPercent();
        BigDecimal q = calculateQ(interestPercent);

        BigDecimal residualAmount = previousRate.getMortgageResidual().getAmount();
        BigDecimal referenceDuration = previousRate.getMortgageReference().getDuration();
        BigDecimal referenceAmount = previousRate.getMortgageReference().getAmount();

        BigDecimal interestAmount = calculateInterestAmount(residualAmount, interestPercent);
        BigDecimal rateAmount = calculateConstantRateAmount(
                q, referenceAmount, referenceDuration,interestAmount,residualAmount);
        BigDecimal capitalAmount = calculateCapitalAmount(rateAmount,interestAmount, residualAmount);
        return new RateAmounts(rateAmount, interestAmount, capitalAmount, overpayment);
    }

    private BigDecimal calculateQ(BigDecimal interestPercent) {
//        obliczenie wspolczynnika q z intrnetu: 1 + (wysokość procentowa / 12)
        return interestPercent.divide(CalculateUtils.YEAR, 10, RoundingMode.HALF_UP).add(BigDecimal.ONE);
    }

    private BigDecimal calculateConstantRateAmount(
            BigDecimal q,
            BigDecimal amount,
            BigDecimal monthDuration,
            BigDecimal interestAmount,
            BigDecimal residualAmount
    ) {
//        R=A*(q^n)*(q-1)/[(q^n)-1]
        BigDecimal  rateAmount = amount
                .multiply(q.pow(monthDuration.intValue()))
                .multiply(q.subtract(BigDecimal.ONE))
                .divide(q.pow(monthDuration.intValue()).subtract(BigDecimal.ONE),50,RoundingMode.HALF_UP);

        return compareWithResidual(rateAmount,interestAmount,residualAmount);
    }

    private BigDecimal compareWithResidual(BigDecimal rateAmount, BigDecimal interestAmount, BigDecimal residualAmount) {
        if(rateAmount.subtract(interestAmount).compareTo(residualAmount)>=0){
            return residualAmount.add(interestAmount);
        }
        return rateAmount;
    }




    private BigDecimal calculateCapitalAmount(BigDecimal rateAmount, BigDecimal interestAmount, BigDecimal residualAmount) {
//        kowta raty - kowata odsetek
        BigDecimal capitalAmount = rateAmount.subtract(interestAmount);
        if(capitalAmount.compareTo(residualAmount) >= 0){
            return residualAmount;
        }
        return capitalAmount;
    }
}
