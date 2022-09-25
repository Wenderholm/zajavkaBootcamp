package com.company.kolekcje.mapAndHashMap;

public class Car {

    private String company;

    private String model;

    private int productionYears;

    public Car(String company, String model, int productionYears) {
        this.company = company;
        this.model = model;
        this.productionYears = productionYears;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getProductionYears() {
        return productionYears;
    }

    public void setProductionYears(int productionYears) {
        this.productionYears = productionYears;
    }

    @Override
    public String toString() {
        return "Car{" +
                "company='" + company + '\'' +
                ", model='" + model + '\'' +
                ", productionYears=" + productionYears +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;

        Car car = (Car) o;

        if (getProductionYears() != car.getProductionYears()) return false;
        if (getCompany() != null ? !getCompany().equals(car.getCompany()) : car.getCompany() != null) return false;
        return getModel() != null ? getModel().equals(car.getModel()) : car.getModel() == null;
    }

    @Override
    public int hashCode() {
        int result = getCompany() != null ? getCompany().hashCode() : 0;
        result = 31 * result + (getModel() != null ? getModel().hashCode() : 0);
        result = 31 * result + getProductionYears();
        return result;
    }
}
