package com.company.projektHipoteczny.service;

import com.company.projektHipoteczny.model.InputData;
import com.company.projektHipoteczny.model.MortgageResidual;
import com.company.projektHipoteczny.model.Rate;
import com.company.projektHipoteczny.model.RateAmounts;

public class ReferenceCalculationServiceImpl implements ReferenceCalculationService{


    @Override
    public MortgageReference calculation(InputData inputData) {
        return new MortgageReference(inputData.getAmount(), inputData.getMonthDuration());
    }
}
