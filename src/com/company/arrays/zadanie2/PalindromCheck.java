package com.company.arrays.zadanie2;

public class PalindromCheck {
    public static void main(String[] args) {
        System.out.println(palindromCheck("natan"));
        System.out.println(palindromCheck("natian"));
    }

    private static boolean palindromCheck(String s) {
        for (int i = 0; i < s.length()/2; i++) {
            if(s.charAt(i) != s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }
}
