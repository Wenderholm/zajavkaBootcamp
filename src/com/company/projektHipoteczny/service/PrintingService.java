package com.company.projektHipoteczny.service;

import com.company.projektHipoteczny.model.InputData;
import com.company.projektHipoteczny.model.Rate;
import com.company.projektHipoteczny.model.Summary;

import java.util.List;

public interface PrintingService {

    String INTEREST_SUM = "SUMA ODSETEK: ";
    String OVERPAYMENT_PROVISION = "PROWIZJA Z NADPLATY: ";
    String OVERPAYMENT_REDUCE_RATE = "NADPLATA ZMNIEJSZENIE RATY ";
    String OVERPAYMENT_REDUCE_PERIOT = "NADPLATA ZMNIEJSZENIE OKRESU";
    String OVERPAYMENT_FREQUENCY = "SCHAMAT DOKONYWANIA NADPLAT: ";
    String LOST_SUM = "SUMA STRAT: ";
    String RATE_NUMBER = "NR: ";
    String YEAR = "ROK: ";
    String MONTH = "MIESIAC: ";
    String DATE = "DATA: ";
    String MONTHS = " MIESIECY ";
    String RATE = "RATA: ";
    String INTEREST = "ODSETKI: ";
    String CAPITAL = "KAPITAL: ";
    String OVERPAYMENT = "NADPLATA: ";
    String LEFT_AMOUNT = "PKWOTA: ";
    String LEFT_MONTHS = "PMSC: ";
    String MORTGAGE_AMOUNT = "KWOTA KREDYTU: ";
    String MORTGAGE_PERIOD = "OKRES KREDYTOWANIA: ";



    String CURRENCY = " ZL ";
    String NEW_LINE = "\n";
    String PERCENT = "% ";

    void printingInputDataInfo(final InputData inputData);

    void printRates(List<Rate> rates);

    void printingSummary(Summary summary);
}
