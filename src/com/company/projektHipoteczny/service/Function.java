package com.company.projektHipoteczny.service;

import com.company.projektHipoteczny.model.Rate;

import java.math.BigDecimal;

public interface Function {

    BigDecimal calculate(Rate rate);
}
