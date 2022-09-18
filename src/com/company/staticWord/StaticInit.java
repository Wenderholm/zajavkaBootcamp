package com.company.staticWord;

public class StaticInit {
       static String value = "a";

    {
        value+= "b";
    }
    static {
        value+= "c";
    }

    {
        value+= "d";
    }



    public static void main(String[] args) {
        System.out.print(StaticInit.value);
        System.out.print(StaticInit.value);
        new StaticInit();
        new StaticInit();
        System.out.print(StaticInit.value);

    }
}
