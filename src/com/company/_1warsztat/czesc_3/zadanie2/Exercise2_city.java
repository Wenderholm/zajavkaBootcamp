package com.company._1warsztat.czesc_3.zadanie2;

import java.util.*;

public class Exercise2_city {

    public static void main(String[] args) {
        List<String> inputPeopleList = List.of(
                "Kowalski +48123333423 Torun",
                "Nawrocki +48789456123 Brodnica",
                "Spychalska +48456121378 Rumia",
                "Rupinski +48963852741 Brodnica",
                "Norwid +48741852963 Rumia"
        );

        List<Person> peopleList = new ArrayList<>();
        for (String person : inputPeopleList) {
            peopleList.add(new Person(person));
        }

//     stowrzenie mapy
        Map<String, List<Person>> phoneBook = new TreeMap<>();
// przejscie po wszystkich osobach

        
        
        for (Person person : peopleList) {
//           sprawdzenie czy istnieje klucz o danej nazwie miasta
            if(!phoneBook.containsKey(person.getCity())){
//                jezeli nie istnieje to tworzymy listę osob nalezacych do danego miasta
                List<Person> byCity = new ArrayList<>();
//                dodajemy do niej osobę
                byCity.add(person);
//                dodajemy do ksiązki telefonicznej nazwy miasta wraz z listą osób pasuyjacych
                phoneBook.put(person.getCity(),byCity);
            }else{
//                jezeli jest klucz o podanej wartosci to wyciag listę z nazwa miasta
                List<Person> byCity = phoneBook.get(person.getCity());
//  dodaje do tej listy kolejną osobę
                byCity.add(person);
//                 dodaje do ksiazki pod dana nazwa kolejna wartosć
                phoneBook.put(person.getCity(),byCity);
            }

        }


        for (Map.Entry<String, List<Person>> entry : phoneBook.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }
}
