package com.company.wyjatkiTryCatch.hierarchia;

public class MyOtherException extends Exception {

    public MyOtherException() {
        super("My other exception was thrown ");
    }

    public MyOtherException(String message) {
        super(message);
    }

    public MyOtherException(String message, Throwable cause) {
        super(message, cause);
    }
}
