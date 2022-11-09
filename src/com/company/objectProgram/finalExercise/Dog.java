package com.company.objectProgram.finalExercise;

// jezeli klasa będzie final to nie będzie można po niej dziedziczyć
public final class Dog {
//    ----------------------------------------------------------------------------
//    w takim przypadku musi być name zainicjalizowane
//    private final String name;

//  1. sposób inicjalizacji
//    private final String name = "";

//  2. sposób inicjalizacji przez konstruktor
//    private final String name;
//    public Dog(String name) {
//        this.name = name;
//    }

//    3. sposób inicjalizowany przez blok inicjalizacyjny
//{
//    this.name = "burek"
//}
//    --------------------------------------------------------------------------
//    KOLEJNOSC PRZYPISYWANIA JAK PONIZEJ
//
//   private final String name = "Helena";
//
//    {
//        this.name = "Burek";
//    }
//
//    public Dog(String name) {
//        this.name = name;
//    }
//
//    public void changeName(String name){
//        this.name = name;
//    }
//    --------------------------------------------------------------------------
//    NAJCZĘSCIEJ WYKONUJE SIĘ TO W TEN SPOSÓB
    private final String name;

    final int a = 5;
// w tym przypadku słowo final blokuje mozliwość przypisania w konstuktorze do parametru  innej wartosci
    public Dog(final String name) {
//        name = "Romek";  <- tak sie nie da blokuje to final
        this.name = name;
    }


}
