package com.company.arrays.zadanie6;

public class Main {
    public static void main(String[] args) {
        numMethod(5);
    }

    private static void numMethod(int size){
        int counter = 0;
        for (int i = 39, j = 11; counter < size; counter++) {
            if(counter == size-1){
                System.out.print(i + ", " + j);
            }else{
                System.out.print(i + ", " + j + ", ");
            }
            i +=2;
            j -=3;
        }
    }
}
