package com.company.wyjatkiTryCatch;

public class Car {
    public void startDriving(){
        System.out.println("one");
        try {
            stopDriving();
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("tow");
        }finally{
            System.out.println("tree");
        }
        System.out.println("four");
    }

    public void stopDriving(){
        System.out.println("five");
        throw new RuntimeException("throwing exception");
//        System.out.println("six");
    }

    public static void main(String[] args) {
        new Car().startDriving();
    }
}
