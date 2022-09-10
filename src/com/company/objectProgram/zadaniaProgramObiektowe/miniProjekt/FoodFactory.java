package com.company.objectProgram.zadaniaProgramObiektowe.miniProjekt;

import com.company.objectProgram.zadaniaProgramObiektowe.miniProjekt.person.Consumer;
import com.company.objectProgram.zadaniaProgramObiektowe.miniProjekt.person.ConsumingMan;
import com.company.objectProgram.zadaniaProgramObiektowe.miniProjekt.person.Producer;
import com.company.objectProgram.zadaniaProgramObiektowe.miniProjekt.person.ProducingMan;
import com.company.objectProgram.zadaniaProgramObiektowe.miniProjekt.produkt.Food;

public class FoodFactory {
    public static void main(String[] args) {
        FoodFactory foodFactory = new FoodFactory();
        foodFactory.run();
    }

    private void run() {
        ProducingMan[] producingPeople = new ProducingMan[]{
                new Producer("Alicja", "Zupek"),
                new Producer("Olek", "Ciastek"),
                new Producer("Tadeusz", "Schabik")
        };

        ConsumingMan[] consumingPeople = new ConsumingMan[]{
                new Consumer("Adam" , "Pozeracz", "chocolate"),
                new Consumer("Rafał", "Zajadacz", "fish"),
                new Consumer("Romek", "Jem", "soup"),

        };

        int counter = 0;
        for (ProducingMan producingPerson : producingPeople) {
            for (ConsumingMan consumingPerson : consumingPeople) {
                counter++;
            }
        }

        Food[] foods = new Food[counter];

        int index = 0;
        for (ProducingMan producingPerson : producingPeople) {
            for (ConsumingMan consumingPerson : consumingPeople) {
                Food food = producingPerson.produce(consumingPerson.getExceptation() , consumingPerson);
                foods[index] = food;
                index++;
            }
        }
        System.out.println("PRINTING FOOD");
        for (Food food : foods) {
            System.out.println(food);
        }
    }
}
