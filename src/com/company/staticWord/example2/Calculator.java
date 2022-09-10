package com.company.staticWord.example2;

public class Calculator {
    public static final double PI = 3.14;
    public static int calculatorSold;
    private String model;

    public Calculator(String model) {
        this.model = model;
        calculatorSold++;
        System.out.println("Sold calculator " + model + ".");
    }

    private static double calculateCircleArea(double radius){
        return PI * Math.pow(radius,2);
    }

    @Override
    protected void finalize() throws Throwable {
        calculatorSold--;
        System.out.println("lost " +
                "" +
                "calculator  " + model + ".");
        super.finalize();
    }
}
