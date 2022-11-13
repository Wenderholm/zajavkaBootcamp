package com.company._1warsztat.unbounded_wildcard;

import java.util.ArrayList;
import java.util.List;

public class UnboundedWildcardMain {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("java course");

        List<Tuna> tunas = new ArrayList<>();
        tunas.add(new Tuna());

//        lista nie zwraca uwagi co jest w środku
        List<?> elements = tunas;
//  powyższy zapis ma ogrniczenia związane z tym że np nie możemy dodać do środka listy nic
//        elements.add("new string?"); <- to się nie doda

//        można usuwać elementy
//        elements.remove(0);

//        można wytświetlać elemetnty
        System.out.println(elements.get(0));

        print(strings);
        print(tunas);

    }

//    <?> unboundedWilecard -> oznacza to że w tym miejscu javy nie interesuje jakie dane będzie miała lista poprostu
//    mówi daj to co masz a typ mnie nie interesuje
    private static void print (List<?> list){
        for (Object o : list) {
            System.out.println(o);
        }
    }

    static class Tuna {

    }
}
