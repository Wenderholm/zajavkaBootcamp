package com.company.lambda.zadania.zadania1;

import com.company.lambda.zadania.Interface1;

public class Main {
    public static void main(String[] args) {


        Interface1 interface1= a -> "nowy string";
        Interface1 interface2 = a -> {
            return "nowy string";
        };
        Interface1 interface3 = (a) -> "nowy string";
        Interface1 interface4 = (int a) -> "nowy string";


        System.out.println(interface1.someMethod(1));
        System.out.println(interface1.someMethod(2));
        System.out.println(interface1.someMethod(3));
        System.out.println(interface1.someMethod(4));


    }

}
