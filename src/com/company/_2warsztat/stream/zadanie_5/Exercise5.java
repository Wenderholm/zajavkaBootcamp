package com.company._2warsztat.stream.zadanie_5;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Exercise5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj słowo do sprawdzenia:");
        String word = sc.nextLine();
        System.out.println("is palindrome: " + isPalindrome(word));
    }

    private static boolean isPalindrome(String sentence) {
        String tempSentence = sentence.replaceAll(" ","").toLowerCase();

        return IntStream.range(0, sentence.length()/2)
                .noneMatch(i -> tempSentence.charAt(i) != tempSentence.charAt(tempSentence.length()-i-1));
    }
}
