package com.company._1warsztat.projekt_warsztat1;

import java.util.ArrayDeque;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CustomQueue<Person> queue = new CustomQueue<>(new ArrayDeque<>(),new ArrayDeque<>());
        PersonCommandProcessor personCommandProcessor = new PersonCommandProcessor(queue);

        List<String> commands = List.of(
                "ADD PERSON(Tomasz_Romanski)",
                "ADD PERSON(Rafal_Adamczuk)",
                "ADD PERSON(Tomasz_Romanski)",
                "ADD PERSON(Mariusz_Wilczek,VIP)",
                "ADD PERSON(Zbigniew_Ratownik)",
                "ADD PERSON(Roman_Tomaszewski,VIP)",
                "PROCESS",
                "LEAVE PERSON(Zbigniew_Ratownik)",
                "LEAVE PERSON(Tomasz_Romanski_2)",
                "PROCESS",
                "PROCESS",
                "PROCESS"
        );
        for (String command : commands) {
            personCommandProcessor.processCommand(command);
        }
    }
}
