package com.company._2warsztat.projekt_Stream;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    static final Integer CURRENT_YEAR = 2020;

    public static void main(String[] args) {
        List<Purchase> productList = DataFactory.produce();
        System.out.println("ZADANIA POZIOM 1 ########################################################");
        System.out.println("zadnie 1 --------------------------------------------");
        Exercise1.run(productList);
        System.out.println("zadnie 2 --------------------------------------------");
        Exercise2.run(productList);
        System.out.println("zadnie 3 --------------------------------------------");
        Exercise3.run(productList);
        System.out.println("zadnie 4 --------------------------------------------");
        Exercise4.run(productList);
        System.out.println("zadnie 5 --------------------------------------------");
        Exercise5.run(productList);

        System.out.println();
        System.out.println("ZADANIA POZIOM 2 ########################################################");
        System.out.println("zadnie 1 --------------------------------------------");
        Exercise6.run(productList);
        System.out.println("zadnie 2 --------------------------------------------");
//        HOBBY,CLOTHES, GARDEN, AUTOMOTIVE
        Exercise7.run(productList, Product.Category.HOBBY);
        System.out.println("zadnie 3 --------------------------------------------");
        Exercise8.run(productList);
        System.out.println("zadnie 4 --------------------------------------------");
        Exercise9.run(productList);
        System.out.println("zadnie 5 --------------------------------------------");
        Exercise10.run(productList);
        System.out.println("zadnie 6 --------------------------------------------");
        Exercise11.run(productList);
        System.out.println("zadnie 7 --------------------------------------------");
        Exercise12.run(productList);

        System.out.println();
        System.out.println("ZADANIA POZIOM 3 ########################################################");
        System.out.println("zadnie 1 --------------------------------------------");
        Exercise13.run(productList);
        System.out.println("zadnie 2 --------------------------------------------");
        Exercise14.run(productList);
    }

    // zadanie 1  Oblicz jaka ilo???? klient??w dokona??a zakupu w naszym sklepie.
    static class Exercise1 {
        static void run(final List<Purchase> productList) {
            long count = productList.stream()
                    .map(person -> person.getBuyer())
//                .peek(elem -> System.out.println(elem))
                    .distinct()
//                .peek(elem -> System.out.println(elem))
                    .count();
            System.out.println("How many clients bought in our shop: " + count);
        }
    }

    static class Exercise2 {
        static void run(final List<Purchase> productList) {
            // zadanie 2. Oblicz jaka ilo???? klient??w p??aci??a Blikiem.
            long count1 = productList.stream()
//                zostawienie tylko tych kt??rzy p??acili BLIK
                    .filter(purchase -> Purchase.Payment.BLIK.equals(purchase.getPayment()))
//                zebranie ludzi kt??rzy p??acili blik
                    .map(buyer -> buyer.getBuyer())
//                usuni??cie duplikat??w ludzi i zliczenie operacji blik
                    .distinct().count();
            System.out.println("BLIK payment: " + count1);

        }
    }

    static class Exercise3 {
        static void run(final List<Purchase> productList) {

// zadanie 3. Oblicz jaka ilo???? klient??w p??aci??a kart?? kredytow??.
            long count2 = productList.stream()
                    .filter(purchase -> Purchase.Payment.CREDIT_CARD.equals(purchase.getPayment()))
                    .map(buyer -> buyer.getBuyer())
                    .distinct().count();
            System.out.println("CREDIT_CARD payment: " + count2);

        }
    }

    static class Exercise4 {
        static void run(final List<Purchase> productList) {
// 4. Oblicz jaka ilo???? zakup??w zosta??a wykonana w walucie EUR.
            long count3 = productList.stream()
                    .filter(many -> many.getProduct().getPrice().getCurrency().equals(Money.Currency.EUR))
//                .peek(elem -> System.out.println(elem + " "))
                    .count();
            System.out.println("Product buoght in Euro :" + count3);

            long euroCollect = productList.stream()
                    .map(purchase -> purchase.getProduct())
                    .filter(product -> Money.Currency.EUR.equals(product.getPrice().getCurrency()))
                    .count();
            System.out.println("Euro collect " + euroCollect);
        }
    }

    static class Exercise5 {
        static void run(final List<Purchase> productList) {

// 5. Oblicz ile unikalnych kupionych produkt??w zosta??o zakupionych w EUR.
            long uniqEuroPurchase = productList.stream()
                    .map(purchase -> purchase.getProduct())
                    .distinct()
                    .filter(many -> many.getPrice().getCurrency().equals(Money.Currency.EUR))
//                .peek(elem -> System.out.println(elem + " "))
                    .count();
            System.out.println("uniqEuroPurchase: " + uniqEuroPurchase);

        }
    }

    static class Exercise6 {
        static void run(final List<Purchase> productList) {
            //  1. Oblicz ile PLN wyda??a w sklepie ka??da z os??b, kt??re dokona??y u nas zakupu. Uwzgl??dnij tylko zakupy dokonane w PLN

            TreeMap<String, BigDecimal> collect = productList.stream()
//                wyfiltroawnie zakup??w w PLN
                    .filter(money -> money.getProduct().getPrice().getCurrency().equals(Money.Currency.PLN))
//                .peek(e -> System.out.println(e))
//                tworzenie podzia??u ze wzgledu na id kupca
                    .collect(Collectors.groupingBy(
//                        wydzielenie wszystkch id kupc??w jako klucze
                            person -> person.getBuyer().getId(),
//                        przyisanie do kolekcji TreeMap
                            () -> new TreeMap<>(),
//                        wypisanie wartosci zakup??w
                            Collectors.mapping(
//                                pomno??enie ceny z iloscia zakupionych rzeczy
                                    p -> p.getProduct().getPrice().getValue().multiply(BigDecimal.valueOf(p.getQuantity())),
//                                dodanie do siebie pomno??onych warto??ci
                                    Collectors.reducing(BigDecimal.ZERO, (currentValue, nextValue) -> currentValue.add(nextValue))
                            )
                    ));
            System.out.println("How much each person spend");
            System.out.println(collect);
            PrintingUtility.printMap(collect);

        }
    }

    static class Exercise7 {
        //        2. Przygotuj metod??, kt??ra przyjmie konkretn?? kategori?? i dla tej kategorii zwr??ci map??, gdzie kluczem
//        b??dzie id klienta, a warto??ci?? ilo???? kupionych przez niego produkt??w z podanej kategorii (we?? pod
//        uwag?? tylko te transakcje, w kt??rych ilo???? kupionych produkt??w jest wi??ksza ni?? 1).
        static void run(final List<Purchase> productList, Product.Category requiredCategory) {
            Map<Client, List<Purchase>> collect = productList.stream()
//                    filtrowanie produktow po wybranej kategorii
                    .filter(product -> requiredCategory.equals(product.getProduct().getCategory()))
//                    filtrowanie produktow po ilosci wiecej niz 1
                    .filter(product -> product.getQuantity() > 1)
//                    stworzenie mapy gdzie k;uczami sa id klienta
                    .collect(Collectors.groupingBy(client -> client.getBuyer()));
//            System.out.println("collect list" + collect);

//            zrobienie z poprzedniej mapy entrySet i z tego streama
            Map<Client, Long> collect1 = collect.entrySet().stream()
                    .collect(Collectors
//                            tworzenie mapy gdzie kluczem jest id Clienta
                            .toMap(key -> key.getKey(),
//                                    z Value czyli listy<purchase> tworzony jest stream i na tym map z wyciagni??ciem ilosci produktow a pozniej sumowanie ilosci produktow
                                    entry -> entry.getValue().stream().map(quantity -> quantity.getQuantity()).reduce(0L, (l, r) -> l + r),
//                                    nast??pnie nastepuje sumowanie value
                                    (a, b) -> Long.sum(a, b),
//                                    typ wyjsciowy dancyh treeMap
                                    () -> new TreeMap<>()
                            ));
            PrintingUtility.printMap(collect1);

        }
    }

    static class Exercise8 {
//        3. Ka??de zam??wienie pocz??tkowo ma status PAID. Zaktualizuj status wszystkich zam??wie??,
//        wykorzystuj??c sprawdzenie statusu ka??dego konkretnego zam??wienia poprzez kod klasy
//        OrderService podany poni??ej. Aby sprawdzi?? status ka??dego zam??wienia wykorzystaj kod klasy
//        OrderService podany poni??ej. Na koniec oblicz ile zam??wie?? zosta??o przetworzonych, czyli maj?? status DONE.

        static void run(final List<Purchase> productList) {
//          I METODA
            long count = productList.stream()
                    .map(p -> new Purchase(p, OrderService.checkOrderStatus(p)))
//                    .peek(el -> System.out.println(el))
                    .filter(p -> Purchase.Status.DONE.equals(p.getStatus()))
                    .count();


            System.out.println("Total number of purchases: " + productList.size());
            System.out.println("Proceed salary 'DONE status': " + count);
        }
    }

    static class Exercise9 {
        //    4. Oblicz ilu unikalnych klient??w kupi??o produkt wyceniony w EUR (klienci nie mog?? si?? powtarza??,
//    pami??taj, ??e jeden m??g?? kupi?? kilka produkt??w). Dodatkowo stw??rz map?? w kt??rej kluczem jest id
//    klienta, a warto??ci?? lista zakup??w produkt??w tego klienta w EUR.
        static void run(final List<Purchase> productList) {
//           W??ASNY SPOS??B
            long purchaseStream = productList.stream()
                    .filter(product -> product.getProduct().getPrice().getCurrency().equals(Money.Currency.EUR))
                    .map(person -> person.getBuyer().getId())
                    .distinct().count();

            TreeMap<String, String> map = productList.stream()
                    .filter(product -> product.getProduct().getPrice().getCurrency().equals(Money.Currency.EUR))
                    .collect(Collectors.groupingBy(
//                            co ma byc jako klucz
                            person -> person.getBuyer().getId(),
//                            rodzaj kolekcji
                            () -> new TreeMap<>(),
//                            co ma byc value i co ma byc z tym zrobione
                            Collectors.mapping(
                                    p -> p.getProduct().getName(),
                                    Collectors.reducing(" ", (currentValue, nextValue) -> currentValue + " " + nextValue)
                            )
                    ));
            System.out.println("osoby kupujace produkt w euro: " + purchaseStream);
            PrintingUtility.printMap(map);

//                    SPOS??B Z ZAJAVKI
            List<Purchase> euroPurchase = productList.stream()
                    .filter(p -> Money.Currency.EUR.equals(p.getProduct().getPrice().getCurrency()))
                    .collect(Collectors.toList());
            long count = euroPurchase.stream()
                    .map(Purchase::getBuyer)
                    .distinct().count();
            System.out.println("Number of unique clients buying products in EUR: " + count);

            Map<String, List<Purchase>> collect = euroPurchase.stream()
                    .collect(Collectors.groupingBy(
                            p -> p.getBuyer().getId()
                    ));
            PrintingUtility.printMap(collect);
        }
    }

    static class Exercise10 {
        //       5. Przygotuj map??, gdzie kluczem b??dzie rocznik klienta, a warto??ciami, lista wszystkich produkt??w
//       jakie klient z danego rocznika kupi??. Rocznik we?? z numeru PESEL, nie musi by?? to pe??ne 1987, mo??e
//       by?? przyk??adowo 87. Posortuj map?? po kluczu rosn??co
        static void run(final List<Purchase> productList) {
            var stream = productList.stream()
                    .collect(Collectors.groupingBy(
                            age -> age.getBuyer().getPesel().toString().substring(0, 2),
                            TreeMap::new,
                            Collectors.mapping(
                                    product -> product.getProduct().getName(),
                                    Collectors.joining(",")
                            )
                    ));
            PrintingUtility.printMap(stream);

//            ROZWIAZANIE ZAJAVKA
            TreeMap<String, List<Client>> collect = productList.stream()
                    .collect(Collectors.groupingBy(
                            p -> p.getBuyer().getYearOfBirth(),
                            TreeMap::new,
                            Collectors.mapping(Purchase::getBuyer, Collectors.toList())
                    ));
            PrintingUtility.printMap(collect);
        }
    }

    static class Exercise11 {
        //    6. Stw??rz map??, gdzie kluczem b??d?? roczniki, a warto??ci?? unikalny zestaw kategorii produkt??w
//    kupionych przez dany rocznik.
        static void run(final List<Purchase> productList) {
            var map = productList.stream()
                    .collect(Collectors.toMap(
                            (Purchase p) -> p.getBuyer().getYearOfBirth(),
                            p -> Set.of(p.getProduct().getCategory()), // 1.spos??b valueMapper
//                            p -> new HashSet<>(List.of(p.getProduct().getCategory()), // 2.spos??b valueMapper
                            (currentSet, nextSet) -> Stream.concat(currentSet.stream(), nextSet.stream()) // 1.spos??b
                                    .collect(Collectors.toSet())
//                            (currentSet, nextSet) -> {
//                                  currentSet.addAll(nextSet)
//                                  return currentSet;
//                            }
                    ));
            PrintingUtility.printMap(map);
        }
    }


    static class Exercise12 {
        //    7. Jaki jest drugi najcz????ciej kupowany produkt? Je??eli kilka produkt??w jest kupionych w takiej samej
        //ilo??ci, posortuj je alfabetycznie po id, i nadal we?? drugi. Czyli sortujesz najpierw po najwi??kszej
        //ilo??ci wyst??pie?? danego produktu, a potem po id.
        static void run(final List<Purchase> productList) {
            Map<String, Long> collect = productList.stream()
//                    wybranie groupingBy zeby miec pogrupowane po jakiejsc wartosci
                    .collect(Collectors.groupingBy(
//                        wartosc wybrana po ktorej bedzie grupowane
                            p -> p.getProduct().getId(),
//                            co bedzie robione z porduktami przypisanymi do id
                            Collectors.mapping(
//                                    wybieramy na czym chcemy pracowac tu wybrane ilosc produktu
                                    p -> p.getQuantity(),
//                                    wybieramy co chcemy z wybranym elementem zrobic tu zsumowac
                                    Collectors.reducing(0L, Long::sum)
                            )
                    ));

            Comparator<? super Pair<String, Long>> pairComparator = Comparator
                    .comparing((Pair<String, Long> p) -> p.getV())
                    .reversed()
                    .thenComparing(p -> p.getU());

            Pair<String, Long> secondMostBoughtProduct = collect.entrySet().stream()
                    .map(entry -> new Pair<>(entry.getKey(), entry.getValue()))
                    .sorted(pairComparator)
                    .skip(1)
                    .findFirst()
//                    .collect(Collectors.toList());
                    .orElse(new Pair<>("Default", 0L));
            PrintingUtility.printMap(collect);
            System.out.println(secondMostBoughtProduct);
        }

    }

    static class Exercise13 {
        //    1. Dla ludzi starszych ni?? 50 lat stw??rz struktur??, w kt??rej zawrzesz informacje: rocznik, najmniej
        //popularna kategoria dla danego rocznika, ilo???? transakcji dla danego rocznika w obr??bie danej
        //kategorii. M??wi??c najmniej popularna mamy na my??li, najmniejsz?? ilo???? dokonanych zakup??w w
        //obr??bie danej kategorii. Np: "rocznik: 62, najmniej popularna kategoria: GARDEN, transakcje: 5"..
        static void run(final List<Purchase> productList) {
            Map<String, Map<Product.Category, Long>> yearsWithCategoriesWithoutZeros = productList.stream()
//                    filtrujemy osoby kt??re maja wiecej niz 60 lat
                    .filter(p -> CURRENT_YEAR - (1900 + Integer.parseInt(p.getBuyer().getYearOfBirth())) > 50)
//                    grupujemy je gdzie kluczem bedzie wiek
                    .collect(Collectors.groupingBy(
                            p -> p.getBuyer().getYearOfBirth(),
//                            value bedzie zagnie??dzona grupa gdzie key bedzie nazwa kategorii
                            Collectors.groupingBy(
                                    p -> p.getProduct().getCategory(),
//                                    value w zagnie??dzonej li??cie b??dzie podliczene ilosci operacji w obrebie danej kategorii
                                    Collectors.counting()
                            )
                    ));
//            po operacji powy??ej mamy list?? kategorii oraz ilo???? zakupionych w niej rzaczy tylko tych kt??re by??y kupione
//            nie wyswietlaja nam sie wartosci 0

//            aby dodac kategorie gdzie nie zosta??a kupiona zadna rzecz nalezy

//            z rezult1 stworzyc entrySet zebysmy mogli operowa?? na kluczach i wartosciach
            var yearsWithCategoriesWithZeros = yearsWithCategoriesWithoutZeros.entrySet().stream()
//                    tworzymy map?? gdzie kluczem jest rok urodzenia a waro??cia b??dzie wewnetrzna mapa z
//                    kluczem kategorii a value bedzie podliczenie ile bylo zakupionych rzeczy w danej kategorii jak nie by??o
//                    ??adnej zakupionej rzeczy to wtedy defaultowo wpis 0
                    .collect(Collectors.toMap(
//                            wiek jako klucz
                                    e -> e.getKey(),
//                            stworzenie streama z kategorii produkt??w zeby??my mogli po nich przelitwerowac
                                    e -> Arrays.stream(Product.Category.values())
//                                    tworzenie mapy )
                                            .collect(Collectors.toMap(
//                                            gdzie kluczem b??dzie albo warto???? jaka jest z porzedniej tabeli albo 0 jak nie bylo takiej warto??ci
                                                                    categoryKey -> e.getValue().getOrDefault(categoryKey, 0L),
//                                           value z wszystkich kategorii (CLOTHES,AUTOMATIVE,GARDEN,HOBBY
                                                                    categoryKey -> List.of(categoryKey),
                                                                    (currentList, nextList) -> Stream.concat(currentList.stream(), nextList.stream())
                                                            .collect(Collectors.toList()),
                                                    TreeMap::new
                                            ))
                    ));
            Map<String, Map.Entry<Long, List<Product.Category>>> mapaFinal = yearsWithCategoriesWithZeros.entrySet().stream()
                    .collect(Collectors.toMap(
//                            key w map z rokiem urodzenia
                            e -> e.getKey(),
//                            value jest po wartosciach ile jakich rzeczy zosta??o zakupionych
                            e -> e.getValue().entrySet().stream()
//                                    wyciagni??cie minimum z wartosci powyzej porownane po
                                    .min(Comparator.comparing(
                                            (Map.Entry<Long, List<Product.Category>> entry) -> entry.getKey()
                                    ))
                                    .get()
                    ));

            PrintingUtility.printMap(yearsWithCategoriesWithoutZeros);
            System.out.println("-------------------------------------------------------------");
            PrintingUtility.printMap(yearsWithCategoriesWithZeros);
            System.out.println("-------------------------------------------------------------");
            PrintingUtility.printMap(mapaFinal);
        }

    }


    static class Exercise14 {
        //    1. ktory rocznik kupil najwiecej produkt  ow.
        static void run(final List<Purchase> productList) {
            Map<String, Long> quantityByYear = productList.stream()
                    .collect(Collectors.groupingBy(
                            p -> p.getBuyer().getYearOfBirth(),
                            Collectors.mapping(
                                    p -> p.getQuantity(),
                                    Collectors.reducing(0L, (a, b) -> a + b)
                               )
                    ));

            Map<Long, Set<String>> yearByQuantity = quantityByYear.entrySet().stream()
                    .collect(Collectors.toMap(
                            e -> e.getValue(),
                            e -> Set.of(e.getKey()),
                            (currentList, nextList) -> Stream.concat(currentList.stream(), nextList.stream())
                                    .collect(Collectors.toSet())
                    ));

            Map.Entry<Long, Set<String>> mostQuantityInTheYear = yearByQuantity.entrySet().stream()
                    .max(Comparator.comparing(Map.Entry::getKey))
                    .orElseThrow(() -> new RuntimeException("No purchase in the shop"));

            PrintingUtility.printMap(quantityByYear);
            System.out.println("------------------------------------------");
            PrintingUtility.printMap(yearByQuantity);
            System.out.printf("Most number of products (%s) was bought by people from years %s",
                    mostQuantityInTheYear.getKey(),
                    mostQuantityInTheYear.getValue());
        }

    }


    public static class PrintingUtility {
        static void printMap(Map<?, ?> map) {
            map.forEach((key, value) -> System.out.println("Key: " + key + ", value: " + value));
        }
// inny sposob tego co powyzej. Jezeli chcielibysmy ograniczy?? dane wejsciowe to wtedy extend przy K lub przy V
//        static <K,V> void printMap(Map<K, V> map) {
//            map.forEach((key, value) -> System.out.println("Key" + key + ", value: " + value));
//        }

    }
}
