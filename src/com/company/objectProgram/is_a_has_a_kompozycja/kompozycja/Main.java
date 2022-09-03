package com.company.objectProgram.is_a_has_a_kompozycja.kompozycja;

public class Main {
    public static void main(String[] args) {
        Honda HondaCity = new Honda();
        HondaCity.setColor("Silver");
        HondaCity.setMaxSpeed(180);
        HondaCity.carDetails();
        HondaCity.HondaStart();
    }
}
