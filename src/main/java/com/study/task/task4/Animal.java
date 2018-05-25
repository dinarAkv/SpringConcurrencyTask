package com.study.task.task4;

public class Animal {
    private static int beanCreationCounter = 0;

    private String kind;
    private int lifeExpectancyAvg;

    public Animal() {
        beanCreationCounter++;
    }

    public Animal(String kind, int lifeExpactancyAvg) {
        this.kind = kind;
        this.lifeExpectancyAvg = lifeExpactancyAvg;
        beanCreationCounter++;
    }

    public static int getBeanCreationCounter() {
        return beanCreationCounter;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public void setLifeExpactancyAvg(int lifeExpactancyAvg) {
        this.lifeExpectancyAvg = lifeExpactancyAvg;
    }
}
