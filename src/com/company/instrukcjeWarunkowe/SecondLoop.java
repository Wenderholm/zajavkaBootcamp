package com.company.instrukcjeWarunkowe;

public class SecondLoop {
    public static void main(String[] args) {
        someLoopingMethod();
    }

    private static void someLoopingMethod() {
        for (int i = 0; i < 3; i++) {
            System.out.println("i = " + i);
            for (int j = 0; j < 3; j++) {
                System.out.println("    j = " + j);
                for (int k = 0; k < 3; k++) {
                    System.out.println("    k = " + k);
                    if(j == 1){
                        return;
                    }
                }
            }
        }
    }
}
