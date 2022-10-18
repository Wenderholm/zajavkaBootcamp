package com.company.projektHipoteczny.service;

import com.company.projektHipoteczny.model.InputData;
import com.company.projektHipoteczny.model.MortgageReference;
import com.company.projektHipoteczny.model.Rate;
import com.company.projektHipoteczny.model.RateAmounts;

public interface ReferenceCalculationService {

    MortgageReference calculate(InputData inputData);

    MortgageReference calculate(InputData inputData, RateAmounts rateAmounts, Rate previousRate);
}
