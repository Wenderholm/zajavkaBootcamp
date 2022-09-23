package com.company.wyjatkiTryCatch.zadaniaWyjatki;

public class MyOwnException extends Exception{
    public MyOwnException() {
        super("MyOwnException called");
    }

    public MyOwnException(String message) {
        super(message);
    }

}
