package com.company.staticWord.Zadania.zadanie3;

public class Child extends AParent {
    public static String getClassName() {
        return "getClassName is Child";
    }

    @Override
    public String getName() {
        return "getName from Child";
    }

    public String otherMethod(){
        return "otherMethod";
    }
}
