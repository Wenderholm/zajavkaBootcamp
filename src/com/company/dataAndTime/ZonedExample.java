package com.company.dataAndTime;

import java.time.*;

public class ZonedExample {
    public static void main(String[] args) {
        System.out.println(ZonedDateTime.now());
//    wyswietlenie id stref czasowych
        System.out.println(ZoneOffset.getAvailableZoneIds());

        ZoneOffset utc = ZoneOffset.UTC;
        ZoneId usPacific = ZoneId.of("US/Pacific");
        ZoneId paris = ZoneId.of("Europe/Paris");

        LocalDate localDate = LocalDate.of(2020, 10, 10);
        LocalTime localTime = LocalTime.of(20, 12, 2);
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);

//        pokazanie czasu oraz odniesienie w jakiej strefie my działamy
        System.out.println(ZonedDateTime.of(localDate, localTime, utc));
        System.out.println(ZonedDateTime.of(localDateTime, utc));
        System.out.println(ZonedDateTime.of(localDateTime, usPacific));
        System.out.println(ZonedDateTime.of(localDateTime, paris));

//        konwetrowanie na localDate, localTime, LocalDateTime
        System.out.println();
        System.out.println("konwertowanie zonedDateTime na inne ");
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime,paris);
        System.out.println("zonedDateTime.toLocalDate " + zonedDateTime.toLocalDate());
        System.out.println("zonedDateTime.toLocalTime " + zonedDateTime.toLocalTime());
        System.out.println("zonedDateTime.toLocalDateTime " + zonedDateTime.toLocalDateTime());
        System.out.println("zonedDateTime.toOffsetDateTime " + zonedDateTime.toOffsetDateTime());

        System.out.println();
        System.out.println("zonedDateTime.getOffset " + zonedDateTime.getOffset());
        System.out.println("zonedDateTime.getZone " + zonedDateTime.getZone());
        System.out.println("zonedDateTime.getDayOfMonth " + zonedDateTime.getDayOfMonth());
        System.out.println("zonedDateTime.getDayOfWeek " + zonedDateTime.getDayOfWeek());
        System.out.println("zonedDateTime.getDayOfYear " + zonedDateTime.getDayOfYear());




    }
}
