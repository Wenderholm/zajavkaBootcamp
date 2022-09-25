package com.company.kolekcje.mapAndHashMap;

import java.util.*;

public class TrainingMap {
    public static void main(String[] args) {
        Map<String, List<String>> citiesAttractions = new HashMap<>();


//        I SPOSÓB deklarowania listy jako value
        List<String> warsawAttraction = new ArrayList<>();
        warsawAttraction.add("Palac kultury i nauki");
        warsawAttraction.add("Metro politechnika");

        citiesAttractions.put("Warszawa", warsawAttraction);

//        II SPOSÓB deklarowania listy jako value
        citiesAttractions.put("Gdynia", Arrays.asList("Galeria handlowa", "Tramwaj nr 1"));

//        III SPOSÓB deklarowania listy jako value
        citiesAttractions.put("London", List.of("London eye","Buckingham palace"));

        System.out.println(citiesAttractions);


        Set<Map.Entry<String, List<String>>> citiesAttractionsEntries = citiesAttractions.entrySet();

        for (Map.Entry<String, List<String>> citiesAttractionsEntry : citiesAttractionsEntries) {
            String key = citiesAttractionsEntry.getKey();
            System.out.println(key);

            for (String attraction : citiesAttractionsEntry.getValue()) {
                System.out.println(key + "'s attraction: " + attraction);

            }
        }

    }
}
