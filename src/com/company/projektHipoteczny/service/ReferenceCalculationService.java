package com.company.projektHipoteczny.service;

import com.company.projektHipoteczny.model.InputData;
import com.company.projektHipoteczny.model.Rate;

public interface ReferenceCalculationService {

    MortgageReference calculation(InputData inputData);
}
