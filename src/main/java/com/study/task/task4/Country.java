package com.study.task.task4;

public class Country {
    private static int beanCreationCounter = 0;

    private String name;
    private long population;

    public Country() {
        beanCreationCounter++;
    }

    public Country(String name, long population) {
        this.name = name;
        this.population = population;
        beanCreationCounter++;
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
