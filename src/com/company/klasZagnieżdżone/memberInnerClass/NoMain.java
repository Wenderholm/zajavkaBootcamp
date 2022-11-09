package com.company.klasZagnieżdżone.memberInnerClass;

public class NoMain {

    public static final String hello = "hello";

    public void call(){
        Inner inner = new Inner("MainInner");
        inner.innerCall();
//        klasa zewnetrzna moze odwolac się do pola prywatnego w klasie wewnetrznej
        System.out.println(inner.hello);

    }


    //    klasa ta może byc public, default, protected, private(tu bedzie dzialalo tyko w tej klasie )
    public class Inner {

//      tak mozna zadeklarowac stała bo jest do niej przypisane już coś
//        public static final String hello = "hello";

//        tak nie mozna zapiasc statica bez przypisania wartosci
//        public static final String helloOther;

//        nie moze być metod statycznych w klasie zagniezdzonej
//        private static void innerStaticCall(){
//        }

        private String hello;

        public Inner(String hello) {
            this.hello = hello;
        }

        public void innerCall(){
            System.out.println("calling inner " + hello);
        }

    }
}
