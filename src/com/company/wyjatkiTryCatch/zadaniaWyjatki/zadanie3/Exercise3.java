package com.company.wyjatkiTryCatch.zadaniaWyjatki.zadanie3;

import com.company.wyjatkiTryCatch.zadaniaWyjatki.MyNextOwnException;
import com.company.wyjatkiTryCatch.zadaniaWyjatki.MyOwnException;

public class Exercise3 {

    private static void exercise3(){
        Exercise3 exercise = new Exercise3();
        try {
            exercise.throwingMethod();
        } catch (MyNextOwnException e) {
            System.out.println("Throwing MyNextOwnException");
        } catch (MyOwnException e) {
            System.out.println("Throwing MyOwnException");
        } catch (Exception e) {
            System.out.println("Throwing Exception");
        }
    }

    private void throwingMethod() throws Exception{
    }

    public static void main(String[] args) {
        exercise3();
    }
}
