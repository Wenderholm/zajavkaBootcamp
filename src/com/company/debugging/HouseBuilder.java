package com.company.debugging;

public class HouseBuilder {

    public House buildHouse(double area, String address){
        return new House(area,address);
    }
}