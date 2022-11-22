package com.company._1warsztat.czesc_1.genericInterface;

public class PackableBag implements Packable<Car>{
    @Override
    public void pack(Car element) {

    }

    @Override
    public Car empty() {
        return null;
    }
}
