package com.company.staticWord.Zadania.zadanie4;

import java.util.Arrays;

public class Exercise4repeat {

    public static void main(String[] args) {
        char[] arr = createSigns(1,45,66,23,11,56,89,123,553,774,24,55,66);
        System.out.println(Arrays.toString(arr));

    }
//    tworzenie tablicy znaków
    private static char[] createSigns(int... args) {
        char[] chars = new char[args.length-handleCase(args)];
        changeIntToCharacters(args,chars);
        return chars;
    }

//    zliacznie ile mam mieć tablica znaków

    private static int handleCase(int[] args){
        int noHandledCases = 0;
        for (int arg : args) {
            if (arg<65 || arg >122){
                System.out.println("Case : " + arg + " not handled." );
                noHandledCases++;
            }
        }
        return noHandledCases;
    }

    private static void changeIntToCharacters(int[] args,char[] chars){
        int j = 0;
        for (int arg : args) {
            if(arg>=65 && arg<=122){
                chars[j] = (char) arg;
                j++;
            }
        }
    }

}
