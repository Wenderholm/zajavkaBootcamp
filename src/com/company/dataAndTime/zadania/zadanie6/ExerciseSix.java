package com.company.dataAndTime.zadania.zadanie6;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ExerciseSix {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2018,5,6);
        LocalTime localTime = LocalTime.of(12, 5, 10);
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDate, localTime, ZoneId.of("Poland"));
        ZonedDateTime zonedDateTime2 = ZonedDateTime.of(localDate, localTime, ZoneId.of("Poland"));
        System.out.println(zonedDateTime);
//        System.out.println(ZoneId.getAvailableZoneIds());
        ZoneId americanZone = ZoneId.of("America/New_York");
        System.out.println("czas amerykanski "+ zonedDateTime.withZoneSameInstant(americanZone));

    }
}
