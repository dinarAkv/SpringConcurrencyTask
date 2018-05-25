package com.study.task.task4;

public class Country {

    private static int beanCreationCounter = 0;

    private String name;
    private long population;

    public Country() {
        System.out.println("Country ");
        beanCreationCounter++;
    }

    public Country(String name, long population) {
        System.out.println("Country " + name + " " + population );
        this.name = name;
        this.population = population;
        beanCreationCounter++;
    }

    public static int getBeanCreationCounter() {
        return beanCreationCounter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }

        Country otherCountry = (Country) obj;

        if (!this.name.equals(otherCountry.name)) {
            return false;
        }
        if (this.population != otherCountry.population) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", population=" + population +
                '}';
    }
}
