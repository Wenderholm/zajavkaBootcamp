package com.company.projektHipoteczny.service;

public class MortgageException extends RuntimeException{

    public MortgageException() {
        super("Case not handled");
    }

    public MortgageException(String message) {
        super(message);
    }
}
