package com.company._1warsztat.czesc_3.zadanie2;

public class Person {
    private final String name;
    private final String phone;
    private final String city;

    public Person(String inputData) {
        String[] split = inputData.split(" ");

        if (split.length == 3) {
            this.name = split[0];
            this.phone = split[1];
            this.city = split[2];
        }else{
            throw new RuntimeException("Wrong input string. " + split + "Name, phone and city separated by space needed");
        }
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Person: {" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
