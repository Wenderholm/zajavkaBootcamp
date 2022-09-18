package com.company.staticWord.Zadania.zadanie5;

public interface IParent {
    default String getName(){
        return "getName() from IParent";
    }

    public static String getClassName(){
        return "getClassName() from IParent";
    }
}
