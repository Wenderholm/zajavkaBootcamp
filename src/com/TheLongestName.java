package com;

public class TheLongestName {
    public static void main(String[] args) {
        String [] nameToCheck = {"roman","annastazja", "edek", "kopek", "annastazzz"};
        System.out.println(findLongestName(nameToCheck));

        System.out.println("factorial");
        System.out.println(factorial(5));


        String[] sentence = {"Learning", "is", "fun.", "Java"};
        int indexOfWordJava = indexOfFirstOccurrence(sentence, "Java");
        System.out.println(indexOfWordJava);
    }


    public static String findLongestName(String [] names){
        int size = names.length;
        String longestName = names[0];
        for(int i = 1; i<size; i++){
            if(names[i].length() > longestName.length()){
                longestName = names[i];
            }
        }
        return longestName;
    }
    public static int factorial(int n){
        int sum = 1;
        for (int i = 1; i <= n; i++) {
            sum = sum * i;
        }
        return sum;
    }

    public static int indexOfFirstOccurrence(String [] stringArrays, String target){
        for (int i = 0; i < stringArrays.length; i++) {
            if(stringArrays[i].equals(target)){
                return i;
            }
        }
        return -1;
    }
}
