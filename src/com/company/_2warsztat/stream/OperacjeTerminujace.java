package com.company._2warsztat.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OperacjeTerminujace {
    public static void main(String[] args) {
        List<String> stringList = List.of("v1","v2","v3","e4");

//        Stream<String> result = stringList.stream()
//                .peek(value -> System.out.println("Value: " + value));

//        nie mozna terminować dwa razy tego samego streama
//        result.collect(Collectors.toList());
//        result.collect(Collectors.toList());


//        trzeba zrobic tak ze kopiujemy stream i wywołujemy terminowanie na kopii
        List<String> result = stringList.stream()
                .peek(value -> System.out.println("Value: " + value))
                .collect(Collectors.toList());

        result.stream()
                .peek( value -> System.out.println("Value: " + value))
                .collect(Collectors.toList());

//        OPERACJE TERMINUJACE:
//        1.COUNT ---------------------------------------------------------------
        System.out.println("count:");
        long count = stringList.stream().count();
        System.out.println(count);
//        2. FINDFIRST | FINDANY -------------------------------------------------
        Optional<String> first = stringList.stream().findFirst();
        System.out.println("findFirst : " + first);
        Optional<String> any = stringList.stream().findAny();
        System.out.println("findAny :" + any);
//        3. MIN  | MAX ---------------------------------------------------------
        System.out.println("MIN");
        Optional<String> min = stringList.stream().min((a1, a2) -> a1.compareTo(a2));
        System.out.println(min);

        System.out.println("MAX");
        Optional<String> max = stringList.stream().max((a1, a2) -> a1.compareTo(a2));
//        Optional<String> max = stringList.stream().max(String::compareTo);
//        Optional<String> max = stringList.stream().max(Comparator.naturalOrder());
        System.out.println(max);

        System.out.println("Max na optional.empty");
        Optional<String> max1 = Stream.<String>empty().max(Comparator.naturalOrder());
        System.out.println(max1);

//        4. ALLMATCH  | ANYMATCH  | NONEMATCH ---------------------------------------------------------
//        ALL MACH SPRAWDZAMY CZY W DANYM STREAMIE WE WSZYTKICH ELEMENTACH ZNAJDUJE SIĘ v
        System.out.println();
        boolean v = stringList.stream()
                .allMatch(elem -> elem.contains("v"));
        System.out.println("allMatch: " + v); // <- false poniewaz mamy jedno e4 nie pasuje do wzorca

//        ANY MACH SPRAWDZAMY CZY W DANYM STREAMIE gdziekolwiek wystepuje V
        System.out.println();
        boolean v1 = stringList.stream()
                .anyMatch(elem -> elem.contains("v"));
        System.out.println("anyMatch: " + v1);

//        NONE MACH SPRAWDZAMY CZY W DANYM STREAMIE WE WSZYTKICH ELEMENTACH nie znajduje sie X
//        jezeli X nie ma w żadnym elemencie to wraca true
        System.out.println();
        boolean v2 = stringList.stream()
                .noneMatch(elem -> elem.contains("x"));
        System.out.println("noneMatch: " + v2);

//        5. FOREACH
        List<String> list = new ArrayList<>();
        stringList.stream().forEach(ele-> {
            list.add(ele);
        });
        System.out.println("myList: " + list);

//        6. REDUCE
        Optional<String> reduce = stringList.stream().reduce((a, b) -> a + b);
        System.out.println(reduce);
        
//        7. COLLECT
        String[] someChars = new String[]{
                "z","a","j","a","v","k","a",
                " ","n","a",
                " ","j","a","v","k","e",
        };

        List<String> collect = Stream.of(someChars)
                .collect(Collectors.toList());

        System.out.println(collect);

        String collect1 = Stream.of(someChars)
                .collect(Collectors.joining(";"));
        System.out.println(collect1);

//        Set<String> collectSet = Stream.of(someChars)
////                // supplier
//                .collect(()->new TreeSet<>(),
////                        accumulator
//                        (currentSet, nextElement) -> currentSet.add(nextElement),
////                        combainer
//                        (leftSide, rightSide)-> leftSide.addAll(rightSide));


// to samo co powyzej z methodReferences
        Set<String> collectSet = Stream.of(someChars)
                .collect(TreeSet::new,TreeSet::add,TreeSet::addAll);

    }
}
