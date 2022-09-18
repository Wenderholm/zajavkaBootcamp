package com.company.staticWord.Zadania.zadanie4;

import java.util.Arrays;

public class Exercise4 {
    public static void main(String[] args) {

        char[] arr = singsCreator(1,68,120,87,111,219,24,34,39,1234,47);
        System.out.println(Arrays.toString(arr));

    }


    private static char[] singsCreator(int... args){
        char[] chars = new char[args.length - calculateNotToHandleCase(args)];
        castToChar(chars,args);
        return chars;
    }



    private static int calculateNotToHandleCase(int[] args){
        int notHandledCases = 0;
        for (int arg : args) {
            if(arg<33 || arg>127){
                System.out.println("Case: " + arg + " not handled");
                notHandledCases++;
            }
        }
        return notHandledCases;
    }

    private static void castToChar(char[] chars, int[] args){
        int j = 0;
        for (int arg : args) {
            if(arg>= 33 && arg <= 127){
                chars[j] = (char) arg;
                j++;
            }
        }
    }

}
