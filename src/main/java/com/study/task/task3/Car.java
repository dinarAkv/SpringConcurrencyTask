package com.study.task.task3;

public class Car {
    private String brand;
    private String model;
    private int year;
    private double cost;

    public Car() {
    }

    public Car(String brand, String model, int year, double cost) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.cost = cost;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
