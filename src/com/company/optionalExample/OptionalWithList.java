package com.company.optionalExample;

import java.util.List;
import java.util.Optional;

public class OptionalWithList {
    public static void main(String[] args) {
        List<String> list = List.of("Brasil", "Denmark", "China", "Poland");

        Optional<String> found = find(list, Optional.of("Poland"));
        System.out.println(found);
    }

    private static Optional<String> find(List<String> countries, Optional<String> element) {
        for (String country : countries) {
            if (element.get().equals(country)) {
                return Optional.of(country);
            }
        }
        return Optional.empty();
    }
}
