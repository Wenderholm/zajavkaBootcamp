package com.company.klasZagnieżdżone.localInnerClass;

public class LocalMain {

//    do tej zmiennej mogę się odwołać w LocalinnerCall
    private String hello = "hello";

    public static void main(String[] args) {

    }

    public void call(){
        int a = 1;
        long b = 2;

//klasa w obrębie jakiejś metody
        class LocalInnerClass{
//            nie mozna tu wpisywać pól statycznych
//            private static String a =1;

//            nie mozna tu wpisywać statycznych metod
//            public static void staticMethod(){
//            }


            public void localInnerCall(){
                System.out.println("LocalInnerClass" + hello);
            }
        }

//        to moze byc uzyte tylko w obrębie metody w której istnieje
        LocalInnerClass localInnerClass = new LocalInnerClass();
        localInnerClass.localInnerCall();
    }
}
