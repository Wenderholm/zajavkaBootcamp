package com.company.wyjatkiTryCatch.hierarchia;

public class MyException extends Exception {
    public MyException(){
        super("My exception was thrown");
    }

    public MyException(String message) {
        super(message);
    }

    public MyException(String message, Throwable cause) {
        super(message, cause);
    }
}
