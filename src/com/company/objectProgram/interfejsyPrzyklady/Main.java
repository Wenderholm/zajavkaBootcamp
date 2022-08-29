package com.company.objectProgram.interfejsyPrzyklady;

public class Main {

    public static void main(String[] args) {

        Ostrich ostrich = new Ostrich();
        Cat cat = new Cat();

        runAnimal(ostrich);
        runAnimal(cat);
    }
// Jeżeli chcielibyśmy teraz wywołać metodę run z różnych zwierząt kótre byśmy stworzyli to musielibyśmy stworzyć tyle
//    metod ile mamy ziwrząt

//    public void runAnimal(Ostrich ostrich){
//        ostrich.run();
//    }
//
//    public void runAnimal(Cat cat){
//        ostrich.run();
//    }
//
//    public void runAnimal(Dog dog){
//        ostrich.run();
//    }

//    ROZWIĄZANIE problemu przy użyciu interejsu
//    w tym przypadku nie ważne jakie zwierze wstawmy to zostanie ono wywołąne przez interfejs animal ponieważ każde
//    zwierze musi zawierac zawartą metodę w Animal
    public static void runAnimal(Animal animal){
        animal.run();
    }
}
