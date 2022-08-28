package com.company.objectProgram.getterAndSetter;

public class Main {

    public static void main(String[] args) {
        Car car = new Car("BMW", null, 2019);
//        Car car2 = null;
//      w tym przypadku będziemy chcieli wywołac metodę na null i dlatego w tym przypadku dostaniemy NullPointerException
//        System.out.println(car2.getProductionYear());

        System.out.println(car.getCompany());
        System.out.println(car.getModel());
        System.out.println(car.getProductionYear());
    }
}
