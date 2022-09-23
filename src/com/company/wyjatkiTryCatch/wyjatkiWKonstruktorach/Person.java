package com.company.wyjatkiTryCatch.wyjatkiWKonstruktorach;

public class Person {
    private int age;

    public Person(int age) throws WrongAgeException {
        if(age > 0 && age < 120){
            this.age = age;
        }else{
            throw new WrongAgeException("what is this kolo");
        }

    }

//    public void someMethod() throws WrongAgeException {
//
//    }
}
