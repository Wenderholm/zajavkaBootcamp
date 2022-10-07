package com.company.dataAndTime.zadania.zadanie5;

import java.time.LocalDate;
import java.time.Period;

public class ExerciseFive {
    public static void main(String[] args) {
        LocalDate localDate1 = LocalDate.of(2018,5,6);
        LocalDate localDate2 = LocalDate.of(2020,8,12);

        System.out.println(Period.between(localDate1, localDate2));
        System.out.println(Period.between(localDate2, localDate1));

    }
}
