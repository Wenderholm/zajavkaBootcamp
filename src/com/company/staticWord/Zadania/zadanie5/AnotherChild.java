package com.company.staticWord.Zadania.zadanie5;

public class AnotherChild implements IParent{

    public static String getClassName(){
        return "getClassName() from AnotherChild";
    }

    @Override
    public String getName() {
        return "getName() from AnotherChild";
    }
}
