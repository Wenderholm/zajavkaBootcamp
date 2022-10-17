package com.company.projektHipoteczny.service;

import com.company.projektHipoteczny.model.InputData;
import com.company.projektHipoteczny.model.Overpayment;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;

public class OverpaymentCalculationServiceImpl implements OverpaymentCalculationService {
    @Override
    public Overpayment calculate(BigDecimal rateNumber, InputData inputData) {
        BigDecimal overpaymentAmount = calculateAmount(rateNumber, inputData.getOverpaymentSchema())
                .orElse(BigDecimal.ZERO);
//        obliczenie prowizji
        BigDecimal overpaymentProvision = calculateProvision(rateNumber, overpaymentAmount, inputData);

        return new Overpayment(overpaymentAmount, overpaymentProvision);
    }

    private Optional<BigDecimal> calculateAmount(BigDecimal rateNumber, Map<Integer, BigDecimal> overpaymentSchema) {
        for (Map.Entry<Integer, BigDecimal> entry : overpaymentSchema.entrySet()) {
//            jezeli numer raty pokrywa się z numerem raty czyli key z overpayment to zwracamy jego wartosc
            if (rateNumber.equals(BigDecimal.valueOf(entry.getKey()))) {
                return Optional.of(entry.getValue());
            }
        }
//         jezeli nie pokryje sie numer raty to pusty oprional trafi do calculateAmount i wypisze nam orElse
        return Optional.empty();
    }

    private BigDecimal calculateProvision(BigDecimal rateNumber, BigDecimal overpaymentAmount, InputData inputData) {
        if (BigDecimal.ZERO.equals(overpaymentAmount)) {
            return BigDecimal.ZERO;
        }
        if (rateNumber.compareTo(inputData.getOverpaymentProvisionMonths()) > 0) {
            return BigDecimal.ZERO;
        }

        return overpaymentAmount.multiply(inputData.getOverpaymentProvisionPercent());
    }
}
