package com.study.task.task3;

public class Country {
    private String name;
    private long population;

    public Country() {
    }

    public Country(String name, long population) {
        this.name = name;
        this.population = population;
    }

    public void setName(String name) {
        this.name = name;
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
