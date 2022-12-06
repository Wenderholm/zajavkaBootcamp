package com.company._2warsztat.interfejsy_funkcyjne.zadanie_2;

public class TaskTwo {


    public static void main(String[] args) {
        ExampleInterface<Car> exImpOne = (someString, someInteger, someObject) ->
                someString.length()
                        + someInteger
                        + someObject.toString().length();
        Integer integer = exImpOne.myInterface("someInput", 5, new Car("mercedes", "GLS"));
        System.out.println(integer);

        ExampleInterface<Car> exImpTwo = (someString, someInteger, someObject) ->{
                return countCar(someString, 'a')
                        + someInteger
                        + countCar(someObject.toString(), ',') +
                        + countCar(someObject.toString(), '=');
        };
;

        Integer integer2 = exImpTwo.myInterface("lambada",1,new Car("Ford", "Mustang"));
        System.out.println(integer2);
    }

    private static Integer countCar (final String someString, final Character searchChar){
        int count = 0;
        for (int i = 0; i < someString.length(); i++) {
            if(someString.charAt(i) == searchChar){
                count++;
            }
        }
        return count;
    }


}


