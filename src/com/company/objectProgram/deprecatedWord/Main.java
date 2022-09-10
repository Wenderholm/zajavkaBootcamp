package com.company.objectProgram.deprecatedWord;


@Deprecated
public class Main {
    @Deprecated
    public String name;

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.name);
    }

}
