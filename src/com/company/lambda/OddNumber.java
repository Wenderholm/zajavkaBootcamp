package com.company.lambda;

public class OddNumber implements Checker{

    @Override
    public boolean check(int number) {
        return number % 2 !=0;
    }
}
