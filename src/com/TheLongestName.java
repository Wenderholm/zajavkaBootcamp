package com;

public class TheLongestName {
    public static void main(String[] args) {
        String [] nameToCheck = {"roman","annastazja", "edek", "kopek", "annastazzz"};
        System.out.println(findLongestName(nameToCheck));
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
}
