package com.company.objectProgram.polimorfizm;


class Mitsubishi extends Car {
    public Mitsubishi(int cylinders, String name) {
        super(cylinders, name);
    }

//    DODATKOWA METODA KTÓREJ NIE MOŻE WYWOŁAĆ REFERENCJA CAR car
    public String horn(){
        return "Mitsubishi - horn()";
    }


    @Override
    public String startEngine() {
        return "Mitsubishi -> startEngine()";
    }

    @Override
    public String accelerate() {
        return "Mitsubishi -> accelerate()";
    }

    @Override
    public String brake() {
        return "Mitsubishi -> break()";
    }
}