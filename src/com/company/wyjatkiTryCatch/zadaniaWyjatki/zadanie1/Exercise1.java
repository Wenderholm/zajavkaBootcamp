package com.company.wyjatkiTryCatch.zadaniaWyjatki.zadanie1;

import com.company.wyjatkiTryCatch.hierarchia.MyException;

public class Exercise1 {

    static void exercise1(){
        Exercise1 exercise = new Exercise1();
        try {
            exercise.exceptionThrowing();
        } catch (MyException e) {
            e.printStackTrace();
        }finally{
            System.out.println("calling finally");
        }
    }


    private void exceptionThrowing() throws MyException {
        throw new MyException("throwing my own exception");
    }


    public static void main(String[] args) {
        exercise1( );
    }

}
