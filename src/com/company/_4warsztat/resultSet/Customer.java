package com.company._4warsztat.resultSet;

import java.time.LocalDate;

public class Customer {
    private final String id;
    private final String userName;
    private final String email;
    private final String name;
    private final String surname;
    private final LocalDate dateOfBirth;
    private final String telephonNumber;


    public Customer(String id, String userName, String email, String name, String surname, LocalDate dateOfBirth, String telephonNumber) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.telephonNumber = telephonNumber;
    }

    public String getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getTelephonNumber() {
        return telephonNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", telephonNumber='" + telephonNumber + '\'' +
                '}';
    }
}
