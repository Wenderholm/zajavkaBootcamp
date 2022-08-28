package com.company.arrays2.zadanie1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String text = "some text to reversing";
        char[] charArr = text.toCharArray();

        System.out.println("reverse text String: " + reverse(text));
        System.out.println("reverse text String array: " + reverse(charArr));
        System.out.println(Arrays.toString(charArr));
//
//        for (int i = 0; i < text.length(); i++) {
//            System.out.print(text.charAt(text.length()-1-i));
//        }

    }
    private static String reverse(String input){
        String result = "";
        for (int i = input.length()-1; i >= 0  ; i--) {
            result += input.charAt(i);
        }
        return result;
    }

    private static String reverse(char[] input){
        String result = "";

        for (int i = input.length - 1 ; i >=0 ; i--) {
            result += input[i];
        }
        return result;
    }
}
