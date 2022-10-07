package com.company.dataAndTime.zadania.zadanie3;

import java.time.LocalDate;

public class ExerciseThree {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2012,6,24);
        System.out.println(localDate.getMonth());

        System.out.println(localDate.toEpochDay());
    }
}
