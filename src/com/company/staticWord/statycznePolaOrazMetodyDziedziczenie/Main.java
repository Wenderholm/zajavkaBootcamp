package com.company.staticWord.statycznePolaOrazMetodyDziedziczenie;

public class Main {

    public static void main(String[] args) {
//        przykład -BEZ STATIC
//        w tym przypadku polimorfizm pozwala na przypisanie różnych typuw do klasy dog
        System.out.println("BEZ STATIC w klasach aniamal i dog");
        Dog2 dog2 = new Dog2();
        Animal2 animal2 = new Dog2();

        dog2.go();
        animal2.go();

//        pola łapane są po typie obiektu a nie klasie
        System.out.println(dog2.name);
        System.out.println(animal2.name);

        System.out.println("----------------------------------");
        System.out.println("Z STATIC w klasach aniam i dog");
//        przykład  -STATIC
//        tu przez referencje dostajemy metodę go() z klas takich jaki jest typ referencji
        Dog dog = new Dog();
        Animal animal = new Dog();

        Dog.go();
        Animal.go();

        System.out.println(Dog.name);
        System.out.println(Animal.name);

    }

}
