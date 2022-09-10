package com.company.staticWord;

public class ReplayStatic {
//    zmienna instancyjna żeby z niej skorzystać trzeba stworzyć obiekt
    private String name;
//      zmienna klasowa (statyczna) zeby z niej skorzystać nie trzeba tworzyć obietku
    public static String staticName;

    public static void main(String[] args) {
//    zmienna lokalna widziana tylko w oberembie konstruktora, metody, bloku inicjalizacyjnego
//     nie widać tej zmiennej w metodzie localVariable()
        int i = 0;


    }

    public void localVariable(){
//        System.out.println(i); <- zmienna z klasy main której nie widzać
    }

//    w metodzie nie statycznej możemy odwoływać się do pól
    public void someMethod(){
        System.out.println(name);
        System.out.println(staticName);
    }

    public static void someMethod2(){
//        System.out.println(name); <- nie można w metodzie statycznej korzystać z zmiennych niestatycznych
//                                      nie istnieją przed stworzeniem obiektu
        System.out.println(staticName);
    }

}
