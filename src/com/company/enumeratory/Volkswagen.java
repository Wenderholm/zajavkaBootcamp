package com.company.enumeratory;

import java.util.ArrayList;
import java.util.List;

public enum Volkswagen  {
    PASSAT("white", 2020){
        @Override
        public Volkswagen ifMissing() {
            return GOLF;
        }
    },
    GOLF("red", 2230){
        @Override
        public Volkswagen ifMissing() {
            return ARTEON;
        }
    },
    ARTEON("yellow", 2450){
        @Override
        public Volkswagen ifMissing() {
            return TIGUAN;
        }
    },
    TIGUAN("green", 2021){
        @Override
        public Volkswagen ifMissing() {
            return TUAREG;
        }
    },
    TUAREG("brown ", 2190){
        @Override
        public Volkswagen ifMissing() {
            return PASSAT;
        }
    };

    private String color;

    private int yearOfProduction;
//    metoda abstrakcyjna
    public abstract Volkswagen ifMissing();

    Volkswagen(String color, int yearOfProduction) {
        this.color = color;
        this.yearOfProduction = yearOfProduction;
    }

//    lista z tymi samymi kolorami
    public static List<Volkswagen> ofColor(String color) {
        List<Volkswagen> result = new ArrayList<>();
        for (Volkswagen value : values()) {
            if(color.equals(value.getColor())){
                result.add(value);
            }
        }

        return result;
    }

    public String getColor() {
        return color;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

//    @Override
//    public String toString() {
//        return "Volkswagen{" +
//                "color='" + color + '\'' +
//                ", yearOfProduction=" + yearOfProduction +
//                "} " + super.toString();
//    }
}
