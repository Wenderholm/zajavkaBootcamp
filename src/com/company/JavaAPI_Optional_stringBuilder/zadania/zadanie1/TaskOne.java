package com.company.JavaAPI_Optional_stringBuilder.zadania.zadanie1;

public class TaskOne {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("może jutro ta dama sama da tortu jeżom");
        StringBuilder clearSb = new StringBuilder(sb.toString().replace(" ",""));


        System.out.println("sb.equals(sb.reverse()): " + sb.equals(sb.reverse()));


        System.out.println("sb.toString().equals(sb.reverse().toString()) :" + sb.toString().equals(sb.reverse().toString()));
        System.out.println("clearSb.toString().equals(clearSb.reverse().toString()) :" + clearSb.toString().equals(clearSb.reverse().toString()));

    }
}
