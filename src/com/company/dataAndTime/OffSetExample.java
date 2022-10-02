package com.company.dataAndTime;

import java.time.*;

public class OffSetExample {
    public static void main(String[] args) {
        System.out.println(OffsetDateTime.now());
        System.out.println("czas UTC czyli czas zulu ");
        System.out.println(OffsetDateTime.now(ZoneId.of("UTC")));
        System.out.println(OffsetDateTime.now(ZoneOffset.UTC));


        LocalDate localDate = LocalDate.of(2020, 10, 10);
        LocalTime localTime = LocalTime.of(20, 12, 2);
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);

        System.out.println("wyswietlenie czasu UTC(zulu)");
        System.out.println("OffsetDateTime.of " + OffsetDateTime.of(localDate,localTime, ZoneOffset.UTC));
        System.out.println("OffsetDateTime.of " + OffsetDateTime.of(localDateTime, ZoneOffset.UTC));
        System.out.println("wyswietlenie czasu UTC(zulu) plus informacja o ile my jestesmy przesunięci");
        System.out.println("OffsetDateTime.of " + OffsetDateTime.of(localDate,localTime, ZoneOffset.of("+05:00")));
        System.out.println("OffsetDateTime.of " + OffsetDateTime.of(localDateTime, ZoneOffset.ofHours(-2)));

        System.out.println("min i max wartość mozliwa do wpisania w offset");
        System.out.println("OffsetDateTime.MAX " + OffsetDateTime.MAX);
        System.out.println("OffsetDateTime.MIN " + OffsetDateTime.MIN);
        System.out.println("minimaln i maksymalna wartość przesunięcia ");
        System.out.println("ZoneOffset.MAX " + ZoneOffset.MAX);
        System.out.println("ZoneOffset.MIN " + ZoneOffset.MIN);
        System.out.println("ZoneOffset.UTC " + ZoneOffset.UTC);
        System.out.println("--------------------------------------");
        OffsetDateTime offsetDateTime = OffsetDateTime.of(localDateTime, ZoneOffset.ofHours(2));

        System.out.println("offsetDateTime original: " + offsetDateTime);
        System.out.println("offsetDateTime.toLocalDate " +offsetDateTime.toLocalDate());
        System.out.println("offsetDateTime.toLocalTime " +offsetDateTime.toLocalTime());
        System.out.println("offsetDateTime.toLocalDateTime " +offsetDateTime.toLocalDateTime());
        System.out.println("offsetDateTime.toZonedDateTime " +offsetDateTime.toZonedDateTime());
        System.out.println("offsetDateTime.getOffset " +offsetDateTime.getOffset());
    }
}
