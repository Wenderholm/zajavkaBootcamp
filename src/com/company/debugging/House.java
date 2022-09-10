package com.company.debugging;

import java.util.Scanner;

public class House {
    private double area;
    private String address;


    public House(double area, String address) {
        constructArea(area);
        assignAddress(address);
    }

    private void assignAddress(String address) {
        this.address = address;
    }

    private void constructArea(double area) {
        System.out.println("Constructor area...");
        buidlWall(8);
        if(area> 0 && area<10){
            this.area = area * 3;
        }else{
            this.area = area;
        }
        System.out.println("Area constructed.");
    }

    private void buidlWall(int brickAmount) {
        for (int i = 0; i < brickAmount; i++) {
            System.out.println("Build brick no " + (i+1));
        }
        System.out.println("Walls built");
    }

    public double getArea() {
        return area;
    }

    public String getAddress() {
        return address;
    }
}
