package com.company.projektHipoteczny.service;

import com.company.projektHipoteczny.model.InputData;
import com.company.projektHipoteczny.model.Rate;
import com.company.projektHipoteczny.model.Summary;

import java.util.List;

public class MortgageCalculationServiceImpl implements MortgageCalculationService {

    private final PrintingService printingService;

    private final RateCalculateService rateCalculateService;

    private final SummaryService summaryService;

    public MortgageCalculationServiceImpl(
            PrintingService printingService,
            RateCalculateService rateCalculateService,
            SummaryService summaryService) {
        this.printingService = printingService;
        this.rateCalculateService = rateCalculateService;
        this.summaryService = summaryService;
    }

    @Override
    public void calculate(InputData inputData) {
        printingService.printingInputDataInfo(inputData);
        List<Rate> rates = rateCalculateService.calculate(inputData);

        Summary summary = summaryService.calculate(rates);
        printingService.printingSummary(summary);

        printingService.printRates(rates);
    }
}
