package com.company.objectProgram.getterAndSetter;

public class Car {

    private String company;
    private String model;
    private int productionYear;
    private int[] array;

    public Car(String company, String model, int productionYear) {
        this.company = company;
        this.model = model;
        this.productionYear = productionYear;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
// zabezpieczenie przed null. jeżeli null to zmaiast błędu NullPointerException mamy napis default.
    public String getModel() {
        return this.model == null ? "default" : this.model;
    }
//zabezpieczenie przed null. jeżeli tablica jest null to tworzy nam tablicę o wielkości 0 a jeżeli nie to naszą tablicę
    public int[] getArray() {
        return this.array == null ? new int[0] : this.array;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }
}
