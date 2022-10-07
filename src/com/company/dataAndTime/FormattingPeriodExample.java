package com.company.dataAndTime;

import java.time.Period;

public class FormattingPeriodExample {
    public static void main(String[] args) {
        String period = "P12Y10M3D";
        System.out.println(Period.parse(period));
        System.out.println(Period.parse("-P12Y10M3D"));
    }
}
