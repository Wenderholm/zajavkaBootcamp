package com.company.projektHipoteczny.service;

import com.company.projektHipoteczny.model.InputData;
import com.company.projektHipoteczny.model.Overpayment;
import com.company.projektHipoteczny.model.Rate;
import com.company.projektHipoteczny.model.RateAmounts;

public interface DecreasingAmountCalculationService {
    RateAmounts calculate(InputData inputData, Overpayment overpayment);

    RateAmounts calculate(InputData inputData, Overpayment overpayment, Rate previousRate);
}
