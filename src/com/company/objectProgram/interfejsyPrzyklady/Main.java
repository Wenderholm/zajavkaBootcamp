package com.company.objectProgram.interfejsyPrzyklady;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Ostrich ostrich = new Ostrich();
        Cat cat = new Cat();

        runAnimal(cat);
        runAnimal(ostrich);

        boolean isMarkeable = ostrich instanceof Markeable;
        System.out.println(isMarkeable);

        System.out.println("**********************");

//        UŻYCIE POLIMORFIZMU
//        nie tworzymy tu obiektu new Animal ponieważ nie możemy stworzyć obiektu interfejsu
//        towrzymy tu tablicę interfejsu animal czyli obiektów które implemendtują interfejs Animal np. mo
        Animal[] animal = new Animal[3];

        for (int i = 0; i < animal.length; i++) {
            if(i % 2 == 0 ){
                animal[i] = new Ostrich();
            }else {
                animal[i] = new Mouse();
            }
        }
        for (Animal animal1 : animal) {
            animal1.run();
        }
        System.out.println(Arrays.toString(animal));

    }
//    do metody możemy sie osnosić za pomoca klas. wada tego podejscia jest taka ze ile stworzymy klas tyle
//    musimy stworzyc metod do wywołania runAnimal

//    public static void runAnimal(Ostrich ostrich){
//        ostrich.run();
//    }
//    public static void runAnimal(Cat cat){
//        cat.run();
//    }
//    public static void runAnimal(Dog dog){
//        dog.run();
//    }

//    ROZWIĄZANIE PROBLEMU przy pomocy interfejsu
//    metoda staje sie uniwersalna kazda klasa która implementuje Animal będzie mogła być wstawiona
//    do metody poniżej i wywołana

    public static void runAnimal(Animal animal){
        animal.run();
    }


}
