package com.company._2warsztat.wstepProgramowanieFunkcyjne;

@FunctionalInterface
public interface SomeFunctionalInterface {
//    interfejs funkcyjny to taki który ma jedną metodę abstrakcyjną
//    domyslnie nie musimy dodawać przed metodę public abstract bo to juz jest z automatu dodane
    void consume(String arg1);


//    intefejs funkcyjny moze miec poza metoda abstrakcyjna metody domyślne i dalej
//    bedzie to interfejs funkcyjny
    default String someDefault(){
        System.out.println("calling default");
        return "someDefault";
    }
    default String someDefault2(){
        System.out.println("calling default2");
        return "someDefault2";
    }
//    intefejs funkcyjny moze miec poza metoda abstrakcyjna i domyślną. metodę statyczną i dalej
//    bedzie to interfejs funkcyjny
    static String someStatic1(){
        System.out.println("calling static1");
        return "someStatic1";

    }
    static String someStatic2(){
        System.out.println("calling static2");
        return "someStatic2";
    }
}
