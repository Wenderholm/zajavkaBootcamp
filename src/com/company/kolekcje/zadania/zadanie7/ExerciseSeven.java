package com.company.kolekcje.zadania.zadanie7;

import java.util.HashMap;
import java.util.Map;

public class ExerciseSeven {
    public static void main(String[] args) {
        String sentence = "jakies zdanie na temat java do sprwadzenia ilosci wystapien danego zanaku w tym zdaniu";
        countSigns(sentence);
    }

    public static void countSigns(String sentence){
        Map<Character, Integer> countMap = new HashMap<>();

        for (int i = 0; i < sentence.length(); i++) {
            Character key = sentence.charAt(i);
            Integer val = countMap.get(key);
            countMap.put(key, val == null ? 1 : val+1);
        }
        System.out.println(countMap);
    }
}
