package com.company.wyjatkiTryCatch.zadaniaWyjatki;

public class MyException extends Exception{

    public MyException() {
        super("my exception was thrown");
    }

    public MyException(String message) {
        super(message);
    }

    public MyException(String message, Throwable cause) {
        super(message, cause);
    }
}
