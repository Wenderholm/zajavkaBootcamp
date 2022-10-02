package com.company.dataAndTime;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class DurationExample {
    public static void main(String[] args) {
        System.out.println("Duration.ofDays " + Duration.ofDays(1));
        System.out.println("Duration.ofHours " + Duration.ofHours(1));
        System.out.println("Duration.ofMinutes " + Duration.ofMinutes(1));
        System.out.println("Duration.ofSeconds " + Duration.ofSeconds(1));
        System.out.println("Duration.ofMillis " + Duration.ofMillis(1));
        System.out.println("Duration.ofNanos " + Duration.ofNanos(1));

//        Duration duration = Duration.ofDays(1);
//        duration = duration.withSeconds(123);
//        System.out.println(duration);


        LocalDate localDate1 = LocalDate.of(2020, 10, 1);
        LocalDate localDate2 = LocalDate.of(2020, 11, 20);
        LocalTime localTime1 = LocalTime.of(20, 10,23);
        LocalTime localTime2 = LocalTime.of(23, 12,27);
        LocalDateTime localDateTime1 = LocalDateTime.of(localDate1, localTime1);
        LocalDateTime localDateTime2 = LocalDateTime.of(localDate2, localTime2);

        Duration duration = Duration.between(localTime1, localTime2);

        Period period = Period.ofDays(1);
        Duration duration1 = Duration.ofDays(1);
        System.out.println(localDate1.plus(period));
//        duration nie zadziała na daniach, miesiacach, latach
//        System.out.println(localDate1.plus(duration));
//        period nie zadziała na godzinach. minutach i sekundach
//        System.out.println(localTime.plus(period));
        System.out.println(localTime1.plus(duration1));
        System.out.println(localDateTime1.plus(period));
        System.out.println(localDateTime1.plus(duration1));

        System.out.println(Duration.between(localTime1, localTime2));

        System.out.println("wypisanie przedziału czasu pomiedzy z określeniem czego oczekujemy");
        System.out.println("ChronoUnit.DAYS.between " + ChronoUnit.DAYS.between(localDate1, localDate2));
//        System.out.println("ChronoUnit.DAYS.between " + ChronoUnit.DAYS.between(localTime1, localTime2));
//        System.out.println("ChronoUnit.HOURS.between " + ChronoUnit.HOURS.between(localDate1, localDate2));
        System.out.println("ChronoUnit.HOURS.between " + ChronoUnit.HOURS.between(localTime1, localTime2));

        System.out.println();
        System.out.println("duration - isNegative() , isZero() , toDays(), toSeconds()");
        System.out.println("duration1.isNegative() " + duration.isNegative());
        System.out.println("duration1.isZero() " + duration.isZero());
        System.out.println(duration);
        System.out.println("duration1.toDays() " + duration.toDays());
        System.out.println("duration1.toHours() " + duration.toHours());
        System.out.println("duration1.toSeconds() " + duration.toSeconds());

        System.out.println();
        System.out.println("obcinanie duratoion do jakiejs wartości ");
        System.out.println(duration);
        System.out.println("duration.truncatedTo " + duration.truncatedTo(ChronoUnit.HOURS));
        System.out.println("duration.truncatedTo " + duration.truncatedTo(ChronoUnit.MINUTES));
        System.out.println("duration.truncatedTo " + duration.truncatedTo(ChronoUnit.SECONDS));
    }
}
