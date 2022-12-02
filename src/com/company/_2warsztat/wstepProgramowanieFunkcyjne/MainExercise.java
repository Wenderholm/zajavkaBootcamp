package com.company._2warsztat.wstepProgramowanieFunkcyjne;

public class MainExercise {
    public static void main(String[] args) {
//        implementacja metody za pomoca lambdy z interfejsu jezeli mamy jedna metodę abstrakcyjna w interfejsie
//        to lambda moze sobie wywnioskować jakie tyby beda przy argumencie i co bedzie zwracane
//        !!!!!!!!! lambda nie moze implementoac metod z klas abstrakcyjnych
        SomeFunctionalInterface interImpl = arg1 -> {
            System.out.println("some argument " + arg1);
        };
//        wywołąnie implementacji z podaniem jakiegos argumentu
        interImpl.consume("test Interfejsu");
    }
}
