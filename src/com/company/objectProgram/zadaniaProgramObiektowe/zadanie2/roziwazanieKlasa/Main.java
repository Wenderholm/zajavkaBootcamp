package com.company.objectProgram.zadaniaProgramObiektowe.zadanie2.roziwazanieKlasa;

import com.company.objectProgram.zadaniaProgramObiektowe.zadanie2.rozwiazanieInterfejs.Function;

public class Main {
    public static void main(String[] args) {
        FunctionClass half = new HalfCalculator();
        FunctionClass quarter = new QuaterCalculator();

        System.out.println(half.calculate(6));
        System.out.println(quarter.calculate(24));
        
        FunctionClass[] funArr = new FunctionClass[10];

        for (int i = 0; i < funArr.length; i++) {
            funArr[i] = i % 2 == 0 ? new HalfCalculator() : new QuaterCalculator();
        }

        int start = 10;

        for (FunctionClass functionClass : funArr) {
            start += functionClass.calculate(start);
        }

        System.out.println(start);
    }
}
