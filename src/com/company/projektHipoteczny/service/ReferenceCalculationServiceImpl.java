package com.company.projektHipoteczny.service;

import com.company.projektHipoteczny.exceptions.MortgageException;
import com.company.projektHipoteczny.model.*;

import java.math.BigDecimal;

import static com.company.projektHipoteczny.service.CalculateUtils.calculateResidualAmount;

public class ReferenceCalculationServiceImpl implements ReferenceCalculationService {


    @Override
    public MortgageReference calculate(InputData inputData) {
        return new MortgageReference(inputData.getAmount(), inputData.getMonthDuration());
    }

    @Override
    public MortgageReference calculate(InputData inputData, RateAmounts rateAmounts, Rate previousRate) {
        if (BigDecimal.ZERO.equals(previousRate.getMortgageResidual().getAmount())) {
            return new MortgageReference(BigDecimal.ZERO, BigDecimal.ZERO);
        }

        switch (inputData.getOverpaymentReduceWay()) {
            case Overpayment.REDUCE_PERIOD:
                return new MortgageReference(inputData.getAmount(), inputData.getMonthDuration());
            case Overpayment.REDUCE_RATE:
                return reduceRateMortgageReference(rateAmounts, previousRate);
            default:
                throw new MortgageException();
        }

    }

    private MortgageReference reduceRateMortgageReference(RateAmounts rateAmounts, Rate previousRate) {
// jezeli nadplata nastapi
        if (rateAmounts.getOverpayment().getAmount().compareTo(BigDecimal.ZERO) > 0) {
            BigDecimal referenceAmount =
                    calculateResidualAmount(previousRate.getMortgageResidual().getAmount(), rateAmounts);
            BigDecimal referenceDuration = previousRate.getMortgageResidual().getDuration().subtract(BigDecimal.ONE);
            return new MortgageReference(referenceAmount,referenceDuration);
        }
//    jezeli nadplata nie nastąpi
        return new MortgageReference(
                previousRate.getMortgageReference().getAmount(),
                previousRate.getMortgageReference().getDuration()
        );
    }



}
