package com.company._3warsztat.code;

import java.text.NumberFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println(Locale.getDefault());
//        wyswietla sie napisy takie jakie mamy Locale.getDefault
//        ResourceBundle resourceBundle = ResourceBundle.getBundle("Store");
//        jezeli chcemy uzywac napisow angielskich
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Store", Locale.ENGLISH);

        String mainPage = resourceBundle.getString("mainPage");
        String footer = resourceBundle.getString("footer");
        String count_info = resourceBundle.getString("count_info");

        System.out.printf(count_info, "two programist", "150kg");
        System.out.println();

        System.out.println(mainPage);
        System.out.println(footer);

//        Map<String, String> collect = resourceBundle.keySet().stream()
//                .collect(Collectors.toMap(
//                        key -> key,
//                        key -> resourceBundle.getString(key)
//                ));
//        tu zostanie wyswietlona mapa gdzie kluczem bedzie defaultProperty, mainPage, footer
//        pomimo wpisania ze chcemy angielska wersje to defaultProperty jest brana z pliku Store.properties poniewaz
//        w pliku Store_en.properties nie ma ustalonego zadnego defaultProperties
//        System.out.println(collect);

//        Locale - formatowanie numerow
        int number = 1_234_567;
        Locale localePL = new Locale("pl","PL");
        Locale localeUS = Locale.US;
        Locale localeGermany = Locale.GERMANY;

        System.out.println("NumberFormat.getInstance():");
        System.out.println("PL: " + NumberFormat.getInstance(localePL).format(number));
        System.out.println("US: " + NumberFormat.getInstance(localeUS).format(number));
        System.out.println("GERMAN: " + NumberFormat.getInstance(localeGermany).format(number));
        System.out.println();

        System.out.println("NumberFormat.getNumberInstance():");
        System.out.println("PL: " + NumberFormat.getNumberInstance(localePL).format(number));
        System.out.println("US: " + NumberFormat.getNumberInstance(localeUS).format(number));
        System.out.println("GERMAN: " + NumberFormat.getNumberInstance(localeGermany).format(number));
        System.out.println();

        System.out.println("NumberFormat.getPercentInstance():");
        System.out.println("PL: " + NumberFormat.getPercentInstance(localePL).format(number));
        System.out.println("US: " + NumberFormat.getPercentInstance(localeUS).format(number));
        System.out.println("GERMAN: " + NumberFormat.getPercentInstance(localeGermany).format(number));
        System.out.println();

        System.out.println("NumberFormat.getCurrencyInstance():");
        System.out.println("PL: " + NumberFormat.getCurrencyInstance(localePL).format(number));
        System.out.println("US: " + NumberFormat.getCurrencyInstance(localeUS).format(number));
        System.out.println("GERMAN: " + NumberFormat.getCurrencyInstance(localeGermany).format(number));
        System.out.println();

//        formatowanie dat
        LocalDate localDate = LocalDate.of(2010, Month.AUGUST,2);
        LocalTime localTime = LocalTime.of(12,52,10);
        LocalDateTime localDateTime = LocalDateTime.of(localDate,localTime);
        OffsetDateTime offsetDateTime = OffsetDateTime.of(localDateTime, ZoneOffset.ofHours(3));
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.of("Poland"));

//        System.out.println(localDate.format(DateTimeFormatter.ISO_LOCAL_DATE));
//        System.out.println(localTime.format(DateTimeFormatter.ISO_LOCAL_TIME));
//        System.out.println(localDateTime.format(DateTimeFormatter.ISO_LOCAL_TIME));

        DateTimeFormatter dateTimeFormatterFULL = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        DateTimeFormatter dateTimeFormatterLONG = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
        DateTimeFormatter dateTimeFormatterMEDIUM = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        DateTimeFormatter dateTimeFormatterSHORT = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);

        System.out.println("FULL " + localDate.format(dateTimeFormatterFULL));
        System.out.println("LONG " + localDate.format(dateTimeFormatterLONG));
        System.out.println("MEDIUM " + localDate.format(dateTimeFormatterMEDIUM));
        System.out.println("SHORT " + localDate.format(dateTimeFormatterSHORT));

        DateTimeFormatter formatterFULL = DateTimeFormatter.ofLocalizedTime(FormatStyle.FULL);
        DateTimeFormatter formatterLONG = DateTimeFormatter.ofLocalizedTime(FormatStyle.LONG);
        DateTimeFormatter formatterMEDIUM = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM);
        DateTimeFormatter formatterSHORT = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);

        System.out.println();
//        System.out.println("FULL " + localTime.format(formatterFULL)); <- blad poniewaz nie moze wyciagnac strefy
//        System.out.println("LONG " + localTime.format(formatterLONG)); <- blad poniewaz nie moze wyciagnac strefy
        System.out.println("MEDIUM " + localTime.format(formatterMEDIUM));
        System.out.println("SHORT " + localTime.format(formatterSHORT));

        DateTimeFormatter formatFULL = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL);
        DateTimeFormatter formatLONG = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        DateTimeFormatter formatMEDIUM = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        DateTimeFormatter formatSHORT = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);

        System.out.println();
//        System.out.println("FULL " + localDateTime.format(formatFULL)); <- blad poniewaz nie moze wyciagnac strefy
//        System.out.println("LONG " + localDateTime.format(formatLONG)); <- blad poniewaz nie moze wyciagnac strefy
        System.out.println("MEDIUM " + localDateTime.format(formatMEDIUM));
        System.out.println("SHORT " + localDateTime.format(formatSHORT));

        System.out.println();
//        System.out.println("FULL " + offsetDateTime.format(formatFULL)); <- blad poniewaz nie moze wyciagnac strefy
//        System.out.println("LONG " + offsetDateTime.format(formatLONG)); <- blad poniewaz nie moze wyciagnac strefy
        System.out.println("MEDIUM " + offsetDateTime.format(formatMEDIUM));
        System.out.println("SHORT " + offsetDateTime.format(formatSHORT));

        System.out.println();
        System.out.println("FULL " + zonedDateTime.format(formatFULL));
        System.out.println("LONG " + zonedDateTime.format(formatLONG));
        System.out.println("MEDIUM " + zonedDateTime.format(formatMEDIUM));
        System.out.println("SHORT " + zonedDateTime.format(formatSHORT));

        DateTimeFormatter formatter_FULL_US = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL).withLocale(Locale.US);
        DateTimeFormatter formatter_LONG_US = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).withLocale(Locale.US);
        DateTimeFormatter formatter_MEDIUM_US = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(Locale.US);
        DateTimeFormatter formatter_SHORT_US = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(Locale.US);

        DateTimeFormatter formatter_FULL_GERMANY = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL).withLocale(Locale.GERMANY);
        DateTimeFormatter formatter_LONG_GERMANY = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).withLocale(Locale.GERMANY);
        DateTimeFormatter formatter_MEDIUM_GERMANY = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(Locale.GERMANY);
        DateTimeFormatter formatter_SHORT_GERMANY = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(Locale.GERMANY);

        System.out.println();
        System.out.println("FULL US " + zonedDateTime.format(formatter_FULL_US));
        System.out.println("FULL GERMANY " + zonedDateTime.format(formatter_FULL_GERMANY));
        System.out.println("LONG US " + zonedDateTime.format(formatter_LONG_US));
        System.out.println("LONG GERMANY " + zonedDateTime.format(formatter_LONG_GERMANY));
        System.out.println("MEDIUM US " + zonedDateTime.format(formatter_MEDIUM_US));
        System.out.println("MEDIUM GERMANY " + zonedDateTime.format(formatter_MEDIUM_GERMANY));
        System.out.println("SHORT US " + zonedDateTime.format(formatter_SHORT_US));
        System.out.println("SHORT GERMANY " + zonedDateTime.format(formatter_SHORT_GERMANY));


    }
}
