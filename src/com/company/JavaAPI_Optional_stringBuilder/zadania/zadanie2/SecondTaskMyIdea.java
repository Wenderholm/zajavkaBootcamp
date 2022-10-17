package com.company.JavaAPI_Optional_stringBuilder.zadania.zadanie2;

public class SecondTaskMyIdea {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("nowe zadnie pisane malymi literami");
        System.out.println(sb);
        extracted(sb);
        System.out.println(sb);
    }

    private static void extracted(StringBuilder sb) {
        int i = 0;
        do {
//            zamiana pierwszej litery na uppercase
            sb.replace(i, i + 1, sb.substring(i, i + 1).toUpperCase());
//            wyszukanie przerwy w zdaniu i ustwienie znacznika na następna pierwsza litere ze zdania
            i = sb.indexOf(" ", i) + 1;
        } while (i > 0 && i < sb.length());
    }
}
