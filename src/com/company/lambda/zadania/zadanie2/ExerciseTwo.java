package com.company.lambda.zadania.zadanie2;

import com.company.lambda.zadania.Interface2;

public class ExerciseTwo {
    public static void main(String[] args) {

        Interface2 interface1 = (a,b) -> "new string";
        Interface2 interface2 = (a,b) -> {
            return "new string";
        };
        Interface2 interface3 = (int a, String b) -> "new string";
        Interface2 interface4 = (int a, String b) -> {
            return "new string";
        };

        System.out.println(interface1.someMethod(1,"one"));
        System.out.println(interface1.someMethod(2,"one"));
        System.out.println(interface1.someMethod(3, "one"));
        System.out.println(interface1.someMethod(4, "one"));
    }
}
