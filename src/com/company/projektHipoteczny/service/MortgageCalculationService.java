package com.company.projektHipoteczny.service;

import com.company.projektHipoteczny.model.InputData;

import java.math.BigDecimal;

public interface MortgageCalculationService {

    public void calculate(final InputData inputData);
}
