package com.company.projektHipoteczny.service;

import com.company.projektHipoteczny.model.InputData;
import com.company.projektHipoteczny.model.Rate;

import java.util.List;

public interface RateCalculateService {

    List<Rate> calculate(InputData inputData);
}
