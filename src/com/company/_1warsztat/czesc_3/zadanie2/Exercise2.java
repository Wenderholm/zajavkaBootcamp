package com.company._1warsztat.czesc_3.zadanie2;

import java.util.*;

public class Exercise2 {
    public static void main(String[] args) {
        List<String> inputPeopleList = List.of(
                "Jan Kowalski +48123333423",
                "Stefan Nawrocki +48789456123",
                "Joanna Spychalska +48456121378",
                "Monika Spychalska +48963852741",
                "Anna Nawrocki +48741852963",
                "Renata Iksiński +48852741963",
                "Magdalena Iksiński +481963741852",
                "Ewa Nawrocki +48159357852",
                "Anna Spychalska +48486426957"
        );

//        stworzenie listy ludzi
        List<Person> peopleList = new ArrayList<>();

//        dodanie ludzi do tablicy
        for (String input : inputPeopleList) {
            peopleList.add(new Person(input));
        }
//      stworzenie ksiazki telefonicznej
        Map<String, List<Person>> phoneBook = new TreeMap<>();
//      dodanie osob do ksiazki telefonicznej
        for (Person person : peopleList) {
            addPersonToPhoneBook(phoneBook,person);
        }

        print(phoneBook);
    }

    private static void print(Map<String, List<Person>> phoneBook) {
        System.out.println("KSIAZKA TELEFONICZNA");
        for (Map.Entry<String, List<Person>> entry : phoneBook.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public static void addPersonToPhoneBook(Map<String,List<Person>> phoneBook, Person person){
        List<Person> bySurnameList = getSurnameList(phoneBook, person);
        bySurnameList.add(person);
        bySurnameList.sort((Comparator.comparing(p -> p.getName())));
        phoneBook.put(person.getSurname(), bySurnameList);
    }

    public static List<Person> getSurnameList(Map<String,List<Person>> phoneBook, Person person){
        return !phoneBook.containsKey(person.getSurname())
                ? new ArrayList<>()
                : phoneBook.get(person.getSurname());
    }

    public static class Person {
        private final String name;
        private final String surname;
        private final String number;


        public Person(String input) {
//            podzielenie wpisanych danych po spacji i wrzucenie do tablicy
            String[] inputData = input.split(" ");
//           sprawdzenie czy podzielony string ma 3 dane w tabelicy
            if(inputData.length == 3){
//                dodanie jako imienia pierwszego miejsca w tablicy
                this.name = inputData[0];
                this.surname =  inputData[1];
                this.number =  inputData[2];
            } else {
                throw new RuntimeException("Wrong input: " + input + " . Name, surname adn phone number " +
                        "separated by space needed");
            }
        }

        public String getName() {
            return name;
        }

        public String getSurname() {
            return surname;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", number='" + number + '\'' +
                    '}';
        }
    }
}
