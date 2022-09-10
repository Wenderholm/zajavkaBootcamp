package com.company.objectProgram.zadaniaProgramObiektowe.miniProjekt.person;

import com.company.objectProgram.zadaniaProgramObiektowe.miniProjekt.produkt.Food;

public interface ProducingMan {
//    klasy dziedziczące musza zwrocic objekt food przyjmujac nazwe
//    oraz kto bedzie konsumował ten produkt
    Food produce(String productName, ConsumingMan consumingMan);
}
