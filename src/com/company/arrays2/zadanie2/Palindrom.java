package com.company.arrays2.zadanie2;

import org.w3c.dom.ls.LSOutput;

public class Palindrom {
    public static void main(String[] args) {
        String text = "naaataaan";
        String text2 = "może jutro ta dama sama da tortu jeżom";
        char[] charArr = text.toCharArray();
        System.out.println(palindromeCheck(charArr));

        String noWhite = text2.replace(" ","");
        String noWhiteReverse = reverse(noWhite);
        String reversed = reverse(text2);


        System.out.println("With white char: " +  reversed + ", equals?: " + text2.equals(reversed));
        System.out.println("No white char: " + noWhiteReverse + ", equals?: " + noWhite.equals(noWhiteReverse));
        System.out.println("moja metoda palindromu: " + palindromeCheck2(text2));
    }

    private static boolean palindromeCheck(char[] input) {
        for (int i = 0; i < input.length / 2; i++) {
            if (input[i] != input[input.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    private static boolean palindromeCheck2(String input) {
//        usunięcie białych znaków
        String removeWitheChar = input.replace(" ", "");
//        zapisanie do tablicy
        char[] charArr = removeWitheChar.toCharArray();
//        porówanie elementu pierwszego z ostanim, drugiego z przedostatnim
        for (int i = 0; i < charArr.length / 2; i++) {
            if (charArr[i] != charArr[charArr.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    private static String reverse(String input){
        String result = "";
        for (int i = input.length()-1; i >= 0  ; i--) {
            result += input.charAt(i);
        }
        return result;
    }


}
