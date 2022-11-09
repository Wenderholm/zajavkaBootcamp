package com.company.klasZagnieżdżone.podsumowania;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
//        JEZELI KLASA FLAT ZAGNIEZDZONA W BLOCKOFFLATS JEST PRIVATE TO MOZNA NA NIEJ DZIALAC TAK

//        List<BigDecimal> areas = List.of(BigDecimal.TEN, BigDecimal.valueOf(15));
//        BlockOfFlats block = new BlockOfFlats(areas);
//
//        System.out.println("getFlats(): " + block.getFlats());
//
////        w ten sposób dodstaniemy błąd ponieważ Flat jest pryvatne i nie dostepne w tym miejscu
////        List<BlockOfFlats.Flat> flats = block.getFlats();
//
////        obejsie problemu powyżej
//        var flats = block.getFlats();
//
//        System.out.println("flats: " + flats);

//        JEZELI FLAT ZAGNIEZDZONA W BLOCKOFFLAT JEST PUBIC TO MOZNA NA NIEJ DZIALAC TAK


        BlockOfFlats block = new BlockOfFlats();

        BlockOfFlats.Flat flat1 = block.new Flat( BigDecimal.TEN);
        BlockOfFlats.Flat flat2 = block.new Flat( BigDecimal.valueOf(15));

        System.out.println(flat1);
        System.out.println(flat2 );

// FINAL I EFFECTIVELY_FINAL
//        final przypisanie zmiennej ktora sie nie zmienia
        final String a = "ZajavkA";

//        effectyvely final wystepuje wtedy gdy do b jest przypisany string i do czasu użycia lambdy nie jest ona
//        w zaden sposób zmieniana. jezeli zostanie zmieniona to wtedy mamy błąd
        String b = "nowaZajavka";

//        b="NoweZdanie";

        Predicate<Integer> somePredicate1 =  someInt -> a.length() > someInt;
        Predicate<Integer> somePredicate2 =  someInt -> b.length() > someInt;

//
        boolean test1 = somePredicate1.test(3);
        boolean test2 = somePredicate2.test(12);
        System.out.println(test1);
        System.out.println(test2);


    }
}

