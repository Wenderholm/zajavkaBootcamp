package com.company._2warsztat.stream;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class StreamPodsumowanie {
    public static void main(String[] args) {
        Set<String> stringSet = new HashSet<>();
        stringSet.add("First");
        stringSet.add("second");

        Stream<String> stream = stringSet.stream();


        Map<String, String> stringMap = new HashMap<>();
        stringMap.put("first", "someValue");
        stringMap.put("second", "someValue");

        Stream<Map.Entry<String, String>> stream1 = stringMap.entrySet().stream();

    }
}
