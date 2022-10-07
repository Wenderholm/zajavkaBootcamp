package com.company.lambda.zadania.zadanie3;

import com.company.lambda.zadania.Interface3;

public class ExerciseThree {
    public static void main(String[] args) {
        Interface3 interface1 = (a,b,c) -> "new String";
        Interface3 interface2 = (a,b,c) -> {
            return "new String";
        };
        Interface3 interface3 = (int a, int b, String c) -> "new String";
        Interface3 interface4 = (int a, int b, String c) -> {
            return "new String";
        };

        System.out.println(interface1.someMethod(1,1,"one"));
        System.out.println(interface1.someMethod(2,1,"one"));
        System.out.println(interface1.someMethod(3,1, "one"));
        System.out.println(interface1.someMethod(4,1, "one"));


        Interface3 interfaceOther = new ImplementationOtherInterfaceClass();

        System.out.println(interfaceOther.someMethod(4, 1, "one"));
    }

}
