package com.company.objectProgram.zadaniaProgramObiektowe.miniProjekt.person;

import com.company.objectProgram.zadaniaProgramObiektowe.miniProjekt.produkt.Chocolate;
import com.company.objectProgram.zadaniaProgramObiektowe.miniProjekt.produkt.Food;
import com.company.objectProgram.zadaniaProgramObiektowe.miniProjekt.produkt.Sandwich;
import com.company.objectProgram.zadaniaProgramObiektowe.miniProjekt.produkt.Soup;

public class Producer extends Person implements ProducingMan {

    public Producer(String name, String surname) {
        super(name, surname);
    }

    @Override
    public void consume(Food food) {
        System.out.println("Producent consuming food " + food);
    }

    @Override
    public String getExceptation() {
        return "no expectations";
    }

    @Override
    public Food produce(String productName, ConsumingMan consumingMan) {
        switch(productName){
            case "chocolate":
//                slowo dis oznacza ten obiek aktualny na ktorym to bedzie wywolane
                return new Chocolate(productName,this, consumingMan);
            case "soup":
                return new Soup(productName,this, consumingMan);
            default:
                return new Sandwich(productName,this, consumingMan);
        }

    }
}
