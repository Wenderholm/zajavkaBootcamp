package com.company.dataAndTime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class LocalExample {
    public static void main(String[] args) {
        System.out.println("LocalDate: " + LocalDate.now());
        System.out.println("LocalTime: " + LocalTime.now());
        System.out.println("LocalDateTime: " + LocalDateTime.now());


        System.out.println("LocalData: " + LocalDate.of(2022,11,2));
        System.out.println("LocalData: " + LocalDate.of(2022, Month.NOVEMBER,2));


        System.out.println("LocalTime: " + LocalTime.of(17,50));
        System.out.println("LocalTime: " + LocalTime.of(17,50,20));
        System.out.println("LocalTime: " + LocalTime.of(17,50,20,902));

        System.out.println("LocalDateTime: " + LocalDateTime.of(
                LocalDate.of(2022,11,2),
                LocalTime.of(17,50,20)
        ));
//      pokaz date 123 dzien w roku 2019
        System.out.println(LocalDate.ofYearDay(2019,123));
// ile dni po epoch rok 1970 p
//okaze date
        System.out.println(LocalDate.ofEpochDay(20000));

//        drukowanie wszystkich miesiecy
        System.out.println(Arrays.toString(Month.values()));

//        jak to godziana dnia po wpisaniu sekund
        System.out.println(LocalTime.ofSecondOfDay(44543));
//        wypisanie czasu stałch
        System.out.println(LocalTime.MIN);
        System.out.println(LocalTime.MAX);
        System.out.println(LocalTime.NOON);
        System.out.println(LocalTime.MIDNIGHT);

        System.out.println(LocalDateTime.from(OffsetDateTime.now()));
        System.out.println(LocalDateTime.MAX);
        System.out.println(LocalDateTime.MIN);


        LocalDate localDate = LocalDate.of(2020,1,20);
        System.out.println("not manipulated: " + localDate);
        System.out.println(" localDate.plusDays " +localDate.plusDays(1));
        System.out.println(" localDate.plusWeeks " +localDate.plusWeeks(2));
        System.out.println(" localDate.plusMonths " +localDate.plusMonths(3));
        System.out.println(" localDate.plusYears " +localDate.plusYears(4));
        System.out.println("--------------------------");
        System.out.println(" localDate.minusDays " +localDate.minusDays(1));
        System.out.println(" localDate.minusWeeks " +localDate.minusWeeks(2));
        System.out.println(" localDate.minusMonths " +localDate.minusMonths(3));
        System.out.println(" localDate.minusYears " +localDate.minusYears(4));
        System.out.println("--------------------------");

        System.out.println("localData.chaining: " + localDate.plusDays(1).minusMonths(2).minusYears(2).plusDays(21));


        LocalTime localTime = LocalTime.of(12, 50, 10);
        System.out.println("Original: " + localTime);
        System.out.println("localTime.plusNanos : " + localTime.plusNanos(10));
        System.out.println("localTime.plusSeconds : " + localTime.plusSeconds(20));
        System.out.println("localTime.plusMinutes : " + localTime.plusMinutes(33));
        System.out.println("localTime.plusHours : " + localTime.plusHours(42));
        System.out.println("----------------------------------------");

        System.out.println("localTime.minusNanos : " + localTime.minusNanos(10));
        System.out.println("localTime.minusSeconds : " + localTime.minusSeconds(20));
        System.out.println("localTime.minusMinutes : " + localTime.minusMinutes(33));
        System.out.println("localTime.minusHours : " + localTime.minusHours(42));

        System.out.println("sekudy i nanosekundy od początku dnia ");
        System.out.println(localTime.toSecondOfDay());
        System.out.println(localTime.toNanoOfDay());
        System.out.println("ilosc sekund od poczatku dnia do daty teraz");
        System.out.println(LocalTime.now().toSecondOfDay());


        LocalDate localDate1 = LocalDate.of(1988, 6, 1);
        LocalTime localTime1 = LocalTime.of(11, 2, 12);
        LocalDateTime localDateTime = LocalDateTime.of(localDate1, localTime1);

        System.out.println("original: " + localDateTime);
        System.out.println("plusYears " + localDateTime.plusYears(1));
        System.out.println("plusMonths " + localDateTime.plusMonths(1));
        System.out.println("plusWeeks " + localDateTime.plusWeeks(1));
        System.out.println("plusDays " + localDateTime.plusDays(1));
        System.out.println("plusHours " + localDateTime.plusHours(1));
        System.out.println("plusMinutes " + localDateTime.plusMinutes(1));
        System.out.println("plusSeconds " + localDateTime.plusSeconds(1));
        System.out.println("plusNanos " + localDateTime.plusNanos(1));

// nowa data z dwoma zmienionymi parametrami
        System.out.println(localDate1.withMonth(8).withYear(2000));
        System.out.println(localDate1.getDayOfWeek());
        System.out.println("wyświetlenie dni tygodnia");
        System.out.println(Arrays.toString(DayOfWeek.values()));

        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_TIME;
        LocalTime localTime3 = LocalTime.parse("00:15:15",formatter);
        System.out.println(localTime3);

    }
}
