package com.company.projektHipoteczny;

import com.company.projektHipoteczny.model.InputData;
import com.company.projektHipoteczny.model.RateType;
import com.company.projektHipoteczny.service.*;

import java.math.BigDecimal;

public class Main {


    public static void main(String[] args) {
        InputData inputData = new InputData()
                .withAmount(new BigDecimal("298000")).withMonthDuration(BigDecimal.valueOf(360)).withRateType(RateType.CONSTANT);

        PrintingService printingService = new PrintingServiceImpl();
        RateCalculateService rateCalculateService = new RateCalculateServiceImpl(
                new TimePointServiceImpl(),
                new AmountsCalculationServiceImpl(),
                new OverpaymentCalculationServiceImpl(),
                new ResidualCalculationServiceImpl(),
                new ReferenceCalculationServiceImpl()
        );

        MortgageCalculationService mortgageCalculationService = new MortgageCalculationServiceImpl(
                printingService,
                rateCalculateService,
                SummaryServiceFactory.create()
                );
        mortgageCalculationService.calculate(inputData);
    }
}
