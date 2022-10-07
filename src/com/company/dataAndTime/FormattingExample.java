package com.company.dataAndTime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class FormattingExample {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2018, Month.OCTOBER, 28);
        LocalTime time = LocalTime.of(1, 50);
        LocalDateTime dateTime = LocalDateTime.of(date, time);
        OffsetDateTime offsetDateTime = OffsetDateTime.of(dateTime, ZoneOffset.ofHours(-4));
        ZonedDateTime zonedDateTime = ZonedDateTime.of(dateTime, ZoneId.of("Europe/Paris"));
        Instant instant = zonedDateTime.toInstant();

        System.out.println(DateTimeFormatter.ISO_LOCAL_DATE.format(date));
//        poniżej zostanie wywałany wyjatek bo nie jest obsługiwany rok
//        System.out.println(Dat    eTimeFormatter.ISO_LOCAL_DATE.format(time));
        System.out.println(DateTimeFormatter.ISO_DATE_TIME.format(dateTime));
        System.out.println(DateTimeFormatter.ISO_LOCAL_DATE.format(offsetDateTime));
        System.out.println(DateTimeFormatter.ISO_LOCAL_DATE.format(zonedDateTime));
//        poniżej zostanie wywałany wyjatek bo nie jest obsługiwany rok
//        System.out.println(DateTimeFormatter.ISO_LOCAL_DATE.format(instant));

//      poniżej zostanie wyswietlony wyjątek ponieważ nie jest wspierane godzina
//        System.out.println(DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(date));
//        System.out.println(DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(time));
        System.out.println(DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(dateTime));
        System.out.println(DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(offsetDateTime));
        System.out.println(DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(zonedDateTime));
//        System.out.println(DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(instant));

//        System.out.println(DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(time));
        System.out.println(DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(dateTime));
        System.out.println(DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(offsetDateTime));
        System.out.println(DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(zonedDateTime));
//        System.out.println(DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(instant));

        System.out.println();

//        System.out.println(DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(date));
//        System.out.println(DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(time));
        System.out.println(DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(dateTime));
        System.out.println(DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(offsetDateTime));
        System.out.println(DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(zonedDateTime));
//        System.out.println(DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(instant));

        System.out.println();
        System.out.println(DateTimeFormatter.RFC_1123_DATE_TIME.format(offsetDateTime));
        System.out.println(DateTimeFormatter.RFC_1123_DATE_TIME.format(zonedDateTime));
        System.out.println();
        System.out.println("Formatowanie FULL, LONG, MEDIUM, SHORT");
        System.out.println("DateTimeFormatter.ofLocalizedDate " + DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).format(zonedDateTime));
        System.out.println("DateTimeFormatter.ofLocalizedDate " + DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).format(zonedDateTime));
        System.out.println("DateTimeFormatter.ofLocalizedDate " + DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).format(zonedDateTime));
        System.out.println("DateTimeFormatter.ofLocalizedDate " + DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).format(zonedDateTime));

        System.out.println();
        System.out.println("Formatowanie FULL, LONG, MEDIUM, SHORT");
        System.out.println("DateTimeFormatter.ofLocalizedDate " + DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL).format(zonedDateTime));
        System.out.println("DateTimeFormatter.ofLocalizedDate " + DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).format(zonedDateTime));
        System.out.println("DateTimeFormatter.ofLocalizedDate " + DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).format(zonedDateTime));
        System.out.println("DateTimeFormatter.ofLocalizedDate " + DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).format(zonedDateTime));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm z");
        System.out.println(formatter.format(zonedDateTime));
        System.out.println();
        System.out.println("PARSE dla localDate, localDateTime, zonedDateTime");
        LocalDate date1 = LocalDate.parse("2020-03-15");
        LocalDateTime dateTime1 = LocalDateTime.parse("2020-03-15T11:50:55");
        ZonedDateTime zoneddateTime1 = ZonedDateTime.parse("2020-03-15T10:30:55+01:00[Europe/Paris]");

    }
}
