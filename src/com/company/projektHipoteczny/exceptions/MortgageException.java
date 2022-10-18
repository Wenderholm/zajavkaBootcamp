package com.company.projektHipoteczny.exceptions;

public class MortgageException extends RuntimeException{

    public MortgageException() {
        super("Case not handled");
    }

    public MortgageException(String message) {
        super(message);
    }
}
