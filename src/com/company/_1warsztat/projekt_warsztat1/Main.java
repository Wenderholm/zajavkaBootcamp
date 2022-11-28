package com.company._1warsztat.projekt_warsztat1;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        dodajemy rodzaje kolejek dla uzytkownika zwykłego oraz VIP
        CustomQueue<Person> queue = new CustomQueue<>(new ArrayDeque<>(), new ArrayDeque<>());
        PersonCommandProcessor personCommandProcessor = new PersonCommandProcessor(queue);
        Scanner sc = new Scanner(System.in);

        System.out.println("Available commends: \n ADD PERSON(Tomasz_Romanski) \n ADD PERSON(Mariusz_Wilczek,VIP) " +
                "\n PROCESS \n LEAVE PERSON(Tomasz_Romanski_2)");
        System.out.println();

        while (sc.hasNext()) {
            String command = sc.nextLine();
            if("EXIT".equals(command)){
                System.out.println("Exit program....");
                break;
            }
            personCommandProcessor.processCommand(command);
        }
        //
//        List<String> commands = List.of(
//                "ADD PERSON(Tomasz_Romanski)",
//                "ADD PERSON(Rafal_Adamczuk)",
//                "ADD PERSON(Tomasz_Romanski)",
//                "ADD PERSON(Mariusz_Wilczek,VIP)",
//                "ADD PERSON(Zbigniew_Ratownik)",
//                "ADD PERSON(Roman_Tomaszewski,VIP)",
//                "PROCESS",
//                "LEAVE PERSON(Zbigniew_Ratownik)",
//                "LEAVE PERSON(Tomasz_Romanski_2)",
//                "PROCESS",
//                "PROCESS",
//                "PROCESS"
//        );
//        for (String command : commands) {
//            personCommandProcessor.processCommand(command);
//        }
    }
}
