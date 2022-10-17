package com.company.JavaAPI_Optional_stringBuilder.optionalExample;

import java.util.Optional;

public class OptionalExamples {
    public static void main(String[] args) {
        Optional<String> op1 = Optional.empty();
        System.out.println(op1);
        Optional<String> op2 = Optional.of("Something");
        System.out.println(op2);

//        PRZYKŁAD PONIŻEJ WYRZUCI BŁĄD BO OPTIONAL NIE MOZE PRZYJĄĆ NULL
//        Optional<String> op3 = Optional.of(null);
//        System.out.println(op3);
        Optional<String> op4 = Optional.ofNullable(null);
        System.out.println(op4);


//        SPRAWDZNIE CZY COŚ W OPTIONALU JEST
        op2.isEmpty();

        System.out.println("Wyswietlenie wartości optionala z warunkiem ");
        if(op2.isPresent()){
            String variable = op2.get();
            System.out.println(variable);

        }

//        JEZELI WIEMY ZE OPTIONAL JEST PUSTY ALE CHCEMY DO NIEGO PRZYPISAC WARTOSC
        String var1 = op1.orElse("Default");
        System.out.println(var1);

        System.out.println("***************************");
//        orElseGet nie zadziała jezeli optional ma jakąś wartość
        String variable1 = op2.orElse(default1());
        String variable2 = op2.orElseGet(() -> default2());
//      orElseGet zadaniała jak optional będzie empty
        System.out.println("++++++++++++++++++++++++++");
        String variable3 = op1.orElse(default1());
        String variable4 = op1.orElseGet(() -> default2());

        System.out.println("_______________________________");
        op1.ifPresentOrElse(element -> System.out.println(element), () -> System.out.println("default"));
        op2 .ifPresentOrElse(element -> System.out.println(element), () -> System.out.println("default"));

    }

    private static String default1() {
        System.out.println("default1");
        return "default1";
    }


    private static String default2() {
        System.out.println("default2");
        return "default2";
    }



}
