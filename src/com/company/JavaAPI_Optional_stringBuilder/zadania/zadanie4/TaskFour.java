package com.company.JavaAPI_Optional_stringBuilder.zadania.zadanie4;

import java.util.Optional;

public class TaskFour {
    public static void main(String[] args) {
        Optional<User> user = findUserByName("Rafał");
        Optional<String> name = user.map(u -> u.getName());
        Optional<String> firstLetter = name.filter(n -> n.startsWith("G"));
        firstLetter.orElseThrow(() -> new RuntimeException("User dose not exist"));
    }

    private static Optional<User> findUserByName(String name) {
        if(name.equals("Rafał")){
            return Optional.of(new User(1,"Rafał","Szybki"));
        }
        return Optional.empty();
    }
}
