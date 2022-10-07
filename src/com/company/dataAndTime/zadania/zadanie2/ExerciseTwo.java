package com.company.dataAndTime.zadania.zadanie2;

import java.time.LocalDate;

public class ExerciseTwo {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2018,5,6);
        System.out.println("dzień tygodnia z podanej daty: " + localDate.getDayOfWeek());
    }
}
