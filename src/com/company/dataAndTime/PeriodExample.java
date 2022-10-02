package com.company.dataAndTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class PeriodExample {
    public static void main(String[] args) {
        System.out.println(Period.of(10,2,60));

        System.out.println("Period.ofDays " + Period.ofDays(2));
        System.out.println("Period.ofMonths " + Period.ofMonths(2));
        System.out.println("Period.ofWeeks " + Period.ofWeeks(2));
        System.out.println("Period.ofYears " + Period.ofYears(2));

        LocalDate localDate1 = LocalDate.of(2020, 10, 1);
        LocalDate localDate2 = LocalDate.of(2020, 12, 1);
        LocalTime localTime = LocalTime.of(20, 10);
        LocalDateTime localDateTime = LocalDateTime.of(localDate1, localTime);

        System.out.println("localDate1.isBefore " +  localDate1.isBefore(localDate2));
        System.out.println("localDate1.isLeapYear " +  localDate1.isLeapYear());
        System.out.println("localDate1.isAfter " +  localDate1.isAfter(localDate2));
        System.out.println();
        System.out.println("localDate1.plus " +  localDate1.plus(Period.of(2, 3, 10)));
//        linijka poniżej nie zadziała ponieważ nie mozna do czasu dodać dni
//        System.out.println(localTime.plus(Period.of(2, 3, 10)));
        System.out.println("localDateTime.plus " + localDateTime.plus(Period.of(2, 3, 10)));

//        wykorzystanie CHRONOUNIT
//        zapytanie czy nasz localData wspiera jakis chronoUnit
        System.out.println(localDate1.isSupported(ChronoUnit.DAYS));
//        ile mamy dodać czyli 2 i czego z wykorzystaniem ENUM
        System.out.println(localDate1.plus(2,ChronoUnit.DAYS));

        System.out.println(localDate1.isSupported(ChronoUnit.MONTHS));
        System.out.println(localDate1.plus(2,ChronoUnit.MONTHS));

        System.out.println(localDate1.isSupported(ChronoUnit.YEARS));
        System.out.println(localDate1.plus(2,ChronoUnit.YEARS));

        System.out.println("metoda between w PERIOD");
        System.out.println("Priot " + Period.between(localDate1, localDate2));
        System.out.println("Priot " + Period.between(localDate1, localDate1));
        System.out.println("Priot " + Period.between(localDate2, localDate1));
        System.out.println();

        System.out.println("Róznice pomiedzy datami ");

        LocalDate localDate3 = LocalDate.of(2020, 10, 1);
        LocalDate localDate4 = LocalDate.of(2021, 12, 1);
        Period period = Period.between(localDate3,localDate4);
        System.out.println("period.get " +  period.get(ChronoUnit.DAYS));
        System.out.println("period.get " +  period.get(ChronoUnit.MONTHS));
        System.out.println("period.get " +  period.get(ChronoUnit.YEARS));
//        kod poniżej nie zadziała ponieważ minuty w tym przypadku nie sa wspierane
//        System.out.println("period.get " + period.get(ChronoUnit.MINUTES));
        System.out.println("period.getDays " + period.getDays());
        System.out.println("period.getMonths " + period.getMonths());
        System.out.println("period.getYears " + period.getYears());
        System.out.println("period to total month: " + period.toTotalMonths());


    }
}
