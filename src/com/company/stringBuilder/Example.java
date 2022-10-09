package com.company.stringBuilder;

public class Example {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        System.out.println(sb.capacity());

        sb.append("World!");
        System.out.println(sb);


        sb.insert(3,"xxx");
        System.out.println(sb);


        sb.replace(1,3,"AAA");
        System.out.println(sb);

        sb.delete(0,3);
        System.out.println(sb);

//        sb.reverse();
        System.out.println(sb);
//        StringBuilder hello = new StringBuilder("hello");
//        for (int i = 0; i < 1000; i++) {
//            hello.append(" World");
//        }
//        System.out.println(hello);

//        POJEMNOSC STRINGBUILDERA TO 16 POCZATKOWA WARTOŚĆ POZNIEJ ROSNIE DO 32
        System.out.println(sb.capacity());
        sb.append(" Java tutorial");
        System.out.println(sb.capacity());

        System.out.println("appendCodePoint " + sb.appendCodePoint(3));

    }
}
