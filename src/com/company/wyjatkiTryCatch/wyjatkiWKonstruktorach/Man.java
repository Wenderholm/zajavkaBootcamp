package com.company.wyjatkiTryCatch.wyjatkiWKonstruktorach;

public class Man extends Person{

    private String favouriteColor;

    public Man(int age) throws WrongAgeException {
//       this -> wywołanie konstruktora poniżej z age i favouriteColor
        this(age, "yellow");
    }

    public Man(int age, String favouriteColor) throws WrongAgeException {
//        super - wywołanie kostruktora z Person
        super(age);
        this.favouriteColor = favouriteColor;
    }

//    jeżeli uzyjemy SUPER chcemy nadpisać metode to musimy dodac wyjatek do obsluzenia
//    bez super nie musimy używać throw
//    @Override
//    public void someMethod() throws WrongAgeException {
//        super.someMethod();
//    }

//    @Override
//    public void someMethod() {
//
//    }
}
