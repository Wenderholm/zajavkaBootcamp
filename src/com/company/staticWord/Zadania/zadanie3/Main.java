package com.company.staticWord.Zadania.zadanie3;

public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        AParent AParent = new Child();


        System.out.println(AParent.getName());
        System.out.println(AParent.getClassName());

        System.out.println(child.getName());
        System.out.println(Child.getClassName());


    }
}
