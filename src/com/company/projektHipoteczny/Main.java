package com.company.projektHipoteczny;

import com.company.projektHipoteczny.model.InputData;
import com.company.projektHipoteczny.model.Overpayment;
import com.company.projektHipoteczny.model.RateType;
import com.company.projektHipoteczny.service.*;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Map;

public class Main {


    public static void main(String[] args) {
        InputData inputData = new InputData()
//                ilosc kredytu
                .withAmount(new BigDecimal("298000"))
//                nadplaty puste
//                .withOverpaymentSchema(Collections.emptyMap())
//                nadplaty w wybranych miesiacach
                .withOverpaymentSchema(Map.of(
                        3,BigDecimal.valueOf(10000),
                        9,BigDecimal.valueOf(10000),
                        16,BigDecimal.valueOf(10000),
                        25,BigDecimal.valueOf(10000)
                ))
//                ilosc rat kredytu
                .withMonthDuration(BigDecimal.valueOf(360))
//               rodzaj rat stale albo malejace
                .withRateType(RateType.CONSTANT)
//                jaki rodzaj nadplaty skracajacy kredyt albo zminejszajacy rate
                .withOverpaymentReduceWay(Overpayment.REDUCE_RATE);

        PrintingService printingService = new PrintingServiceImpl();
        RateCalculateService rateCalculateService = new RateCalculateServiceImpl(
                new TimePointServiceImpl(),
                new AmountsCalculationServiceImpl(
                        new ConstantAmountCalculationServiceImpl(),
                        new DecreasingAmountCalculationServiceImpl()),
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
