package com.company.wyjatkiTryCatch.wyjatkiWKonstruktorach;

public class ConsturctorExample {
    private long parameter;

    public ConsturctorExample(long parameter) {
        if(parameter > 0 && parameter < 10){
            this.parameter = parameter;
        }else{
            throw new RuntimeException("what is this kolo");
        }
    }

    public static void main(String[] args) {
        try {
            Person person = new Man(130);
        } catch (WrongAgeException e) {
            System.out.println("oops");
        }
    }
}
