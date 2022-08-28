package com.company.operatorsExercise.zadanie4;

public class Main {
    public static void main(String[] args) {
//        int brown = 0;
//        int red = 1;
//        int green = 2;
//        int blue = 3;
//        int black = 4;
//        int yellow = 5;

        int numberOfColours = 6;
        int maxNumber = 100;

        int result = maxNumber % numberOfColours;
        switch (result) {
            case 0:
                System.out.println("the last color is brown");
                break;
            case 1:
                System.out.println("the last color is red");
                break;
            case 2:
                System.out.println("the last color is green");
                break;
            case 3:
                System.out.println("the last color is blue");
                break;
            case 4:
                System.out.println("the last color is black");
                break;
            case 5:
                System.out.println("the last color is yellow");
                break;
        }
    }
}
