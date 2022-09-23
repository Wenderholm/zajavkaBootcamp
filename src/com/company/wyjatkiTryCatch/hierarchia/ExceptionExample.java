package com.company.wyjatkiTryCatch.hierarchia;

import java.util.Arrays;

public class ExceptionExample {
    public static void main(String[] args) {
// HIERACHIA WYJATKÓW PRZECHODZIMY OD BARDZIEJ SZCZEGÓŁOWYCH DO MNIEJ
        try {
            printSomething1("ThRow");
        } catch (MyOtherException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Exception caught: " + Arrays.toString(e.getStackTrace()));
        }
    }

    public static void printSomething1(final String input) throws MyOtherException {
        printSomething2(input);
    }

    private static void printSomething2(final String input) throws MyOtherException {
        try {
            printSomething3(input);
        } catch (Exception e) {
            throw new MyOtherException("My other exception message ", e);
        }
    }

    public static void printSomething3(final String input) throws MyException {
        printSomething4(input);
    }

    public static void printSomething4(final String input) throws MyException {
        if ("Throw".equalsIgnoreCase(input)) {
            throw new MyException("My runtime exception");
        } else {
            System.out.println(input);
        }
    }
}
