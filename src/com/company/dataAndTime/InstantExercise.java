package com.company.dataAndTime;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class InstantExercise {
    public static void main(String[] args) {
        LocalDate date1 = LocalDate.of(2020, 11, 3);
        LocalTime time1 = LocalTime.of(12, 36);

        ZoneId zone1 = ZoneId.of("Europe/Belgrade");
        ZoneId zone2 = ZoneId.of("Asia/Singapore");
        System.out.println("bez  toInstante()");
        System.out.println(ZonedDateTime.of(date1, time1, zone1));
        System.out.println("z  toInstante()");
        System.out.println(ZonedDateTime.of(date1, time1, zone1).toInstant());
        System.out.println(ZonedDateTime.of(date1, time1, zone2));
        System.out.println(ZonedDateTime.of(date1, time1, zone2).toInstant());
    }
}
