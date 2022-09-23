package com.company.wyjatkiTryCatch.zadaniaWyjatki.zadanie2;

import com.company.wyjatkiTryCatch.zadaniaWyjatki.MyOwnException;

public class Exercise2 {
    private static void exercise2(){
        wrapper();
    }


    public static void wrapper(){
        Exercise2 exercises = new Exercise2();
        try {
            exercises.ageValidation(18);
        } catch (MyOwnException e) {
            throw new RuntimeException(e);
        }
    }

    public void ageValidation(int age) throws MyOwnException {
        if(age<21){
            throw new MyOwnException("age is a problem. you have only: " + age);
        }
    }

    public static void main(String[] args) {
        wrapper();
    }
}
