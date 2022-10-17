package com.company.JavaAPI_Optional_stringBuilder.zadania.zadanie4;

import java.util.Optional;

public class TaskFive {
    public static void main(String[] args) {
        Optional<User> user = findUserByName("Rafał");
        Optional<User> or = user.or(() -> Optional.of(new User()));
        or.ifPresent(u -> System.out.println("user exits"));
    }

    private static Optional<User> findUserByName(String name) {
        if(name.equals("Rafał")){
            return Optional.of(new User(1,"Rafał","Szybki"));
        }
        return Optional.empty();
    }
}
