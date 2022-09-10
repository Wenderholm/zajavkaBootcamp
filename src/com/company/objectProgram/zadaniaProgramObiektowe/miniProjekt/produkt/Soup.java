package com.company.objectProgram.zadaniaProgramObiektowe.miniProjekt.produkt;

import com.company.objectProgram.zadaniaProgramObiektowe.miniProjekt.person.ConsumingMan;
import com.company.objectProgram.zadaniaProgramObiektowe.miniProjekt.person.ProducingMan;
import com.company.objectProgram.zadaniaProgramObiektowe.miniProjekt.produkt.Food;

public class Soup extends Food {
    public Soup(String name, ProducingMan producingMan, ConsumingMan consumingMan) {
        super(name, producingMan, consumingMan);
    }
}

