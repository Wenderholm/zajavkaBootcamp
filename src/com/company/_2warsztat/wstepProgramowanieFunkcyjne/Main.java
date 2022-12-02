package com.company._2warsztat.wstepProgramowanieFunkcyjne;

import com.company.staticWord.Zadania.zadanie2.Static;

public class Main {
    public static void main(String[] args) {

//        higer order function - przyjmuje funkcje bądz ją zwraca
        ISomeInterface someInstance = someStaticMethod(someString -> System.out.println(someString));
        someInstance.someMethod("test1");
        System.out.println(factorialRecursive(0));
        System.out.println(factorialRecursive(1));
        System.out.println(factorialRecursive(2));
        System.out.println(factorialRecursive(3));
        System.out.println(factorialRecursive(4));
        System.out.println(factorialRecursive(5));
        System.out.println(factorialRecursive(6));

    }


    static ISomeInterface someStaticMethod(ISomeInterface function){
        function.someMethod("some string");
        return otherInput -> System.out.println("return: " + otherInput);
    }

    interface ISomeInterface {
        void someMethod(String input);
    }

    static Integer factorialRecursive(int n){
        if(n == 0){
            return 1;
        }
        return n * factorialRecursive(n-1);
    }

}
