package com.company.projektHipoteczny.service;

import com.company.projektHipoteczny.model.InputData;
import com.company.projektHipoteczny.model.TimePoint;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class TimePointServiceImpl implements TimePointService {

    private static final BigDecimal YEAR = BigDecimal.valueOf(12);


    @Override
    public TimePoint calculate(BigDecimal rateNumber, InputData inputData) {
        LocalDate date = calculateDate(rateNumber, inputData);
        BigDecimal year = calculateYear(rateNumber);
        BigDecimal month = calculateMonth(rateNumber);
        return new TimePoint(date,year,month);
    }

    private LocalDate calculateDate(BigDecimal rateNumber, InputData inputData) {
        return inputData.getRepaymentStartDate()
                .plus(rateNumber.subtract(BigDecimal.ONE).intValue(), ChronoUnit.MONTHS);
    }

    private BigDecimal calculateYear(final BigDecimal rateNumber){
//        jezeli dostaniemy wartość mniejszą niż jeden to wypisze z max() jedynkę a jeżęli będzie większa niż jeden to wypisze tą większą
//        rok rozpoczecia kredytowania musi byc conajmniej 1

        return rateNumber.divide(YEAR, RoundingMode.UP).max(BigDecimal.ONE);
    }

    private BigDecimal calculateMonth(final BigDecimal rateNumber){
        return BigDecimal.ZERO.equals(rateNumber.remainder(YEAR)) ? YEAR : rateNumber.remainder(YEAR);
    }
}
