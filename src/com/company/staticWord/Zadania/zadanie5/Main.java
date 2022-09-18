package com.company.staticWord.Zadania.zadanie5;

public class Main {
    public static void main(String[] args) {
        IParent iParent = new AnotherChild();
        AnotherChild child = new AnotherChild();

        System.out.println(iParent.getName());
        System.out.println(child.getName());
        System.out.println(AnotherChild.getClassName());

    }
}
