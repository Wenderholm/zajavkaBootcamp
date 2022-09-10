package com.company.objectProgram.zadaniaProgramObiektowe.miniProjekt.produkt;

import com.company.objectProgram.zadaniaProgramObiektowe.miniProjekt.person.ConsumingMan;
import com.company.objectProgram.zadaniaProgramObiektowe.miniProjekt.person.ProducingMan;
import com.company.objectProgram.zadaniaProgramObiektowe.miniProjekt.produkt.Food;

public class Chocolate extends Food {

    public Chocolate(String name, ProducingMan producingMan, ConsumingMan consumingMan) {
        super(name, producingMan, consumingMan);
    }
}
