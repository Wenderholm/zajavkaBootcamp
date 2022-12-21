package com.company._3warsztat.serializableExercise;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File destination = new File("object.whatever");
        List<Car> cars = new ArrayList<>();
//
//        cars.add(new Car("Ford Mustang" , 1969L, List.of(new Door("left"), new Door("right"))));
//        cars.add(new Car("BMW" , 2015L, List.of(new Door("left"), new Door("right"))));
//        cars.add(new Car("Mercedes G-class" , 2004L, List.of(new Door("left"), new Door("right"))));

        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog("Burek", "Burecki"));
        dogs.add(new Dog("Fafik", "Fafikowy"));
        dogs.add(new Dog("Aport", "Aporciński"));

        serialize(dogs, destination);
        System.out.println("SERIALIZED");
        System.out.println();
        System.out.println();
//        serialize(cars, destination);
        System.out.println("DESERIALIZED START");
        List<Dog> deserialized = deserialize(destination);
        System.out.println("DESERIALIZED START");
        System.out.println(deserialized);
    }

    private static void serialize(List<?> objects, File destination) throws IOException {
        try (
                ObjectOutputStream outputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(destination)))
        ) {
            for (Object object : objects) {
                outputStream.writeObject(object);
            }
        }
    }

//    DESERIALIZACJA DLA CAR
//    private static List<Car> deserialize(File destination) throws IOException, ClassNotFoundException {
//        List<Car> result = new ArrayList<>();
//        try( ObjectInputStream inputStream = new ObjectInputStream(new BufferedInputStream( new FileInputStream(destination)))
//
//        ){
//            while (true){
////                odczytanie objektu
//                Object object = inputStream.readObject();
////                jezeli dany objekt nie jest klasy Car to wypisujemy informację
//                if(!(object instanceof Car)){
//                    System.out.println("Object is not CAR!");
//                    continue;
//                }
////                jezeli dany obiekt jest klasy car
//                Car concreteObject = (Car) object;
//                System.out.println("Successfully read Car: " + concreteObject);
////                objekt zostaje skastowany na Car i dodany do tablicy result
//                result.add(concreteObject);
//            }
//// ten wyjątek zostanie wyrzucony jak się zakończy wczytywanie plików
//        }catch (EOFException e){
//            System.out.println("end of file");
//        }
//        return result;
//    }

//    DESERIALIZACJA DLA DOG
    private static List<Dog> deserialize(File destination) throws IOException, ClassNotFoundException {
        List<Dog> result = new ArrayList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(destination)))

        ) {
            while (true) {
//                odczytanie objektu
                Object object = inputStream.readObject();
//                jezeli dany objekt nie jest klasy Dog to wypisujemy informację
                if (!(object instanceof Dog)) {
                    System.out.println("Object is not CAR!");
                    continue;
                }
//                jezeli dany obiekt jest klasy car
                Dog concreteObject = (Dog) object;
                System.out.println("Successfully read Car: " + concreteObject);
//                objekt zostaje skastowany na Car i dodany do tablicy result
                result.add(concreteObject);
            }
// ten wyjątek zostanie wyrzucony jak się zakończy wczytywanie plików
        } catch (EOFException e) {
            System.out.println("end of file");
        }
        return result;
    }

}
