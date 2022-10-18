package com.company.projektHipoteczny.service;

import com.company.projektHipoteczny.exceptions.MortgageException;
import com.company.projektHipoteczny.model.InputData;
import com.company.projektHipoteczny.model.Overpayment;
import com.company.projektHipoteczny.model.Rate;
import com.company.projektHipoteczny.model.RateAmounts;

public class AmountsCalculationServiceImpl implements AmountsCalculationService {

    private final ConstantAmountCalculationService constantAmountCalculationService;

    private final DecreasingAmountCalculationService decreasingAmountCalculationService;

    public AmountsCalculationServiceImpl(
            ConstantAmountCalculationService constantAmountCalculationService,
            DecreasingAmountCalculationService decreasingAmountCalculationService
    ) {
        this.constantAmountCalculationService = constantAmountCalculationService;
        this.decreasingAmountCalculationService = decreasingAmountCalculationService;
    }

    @Override
    public RateAmounts calculate(InputData inputData, Overpayment overpayment) {
        switch (inputData.getRateType()) {
            case CONSTANT:
                return constantAmountCalculationService.calculate(inputData, overpayment);
            case DECREASING:
                return decreasingAmountCalculationService.calculate(inputData, overpayment);
            default:
                throw new MortgageException();
        }
    }

    @Override
    public RateAmounts calculate(InputData inputData, Overpayment overpayment,  Rate previousRate) {
        switch (inputData.getRateType()) {
            case CONSTANT:
                return constantAmountCalculationService.calculate(inputData, overpayment, previousRate);
            case DECREASING:
                return decreasingAmountCalculationService.calculate(inputData, overpayment, previousRate);
            default:
                throw new MortgageException();
        }
    }

}
