package com.study.task.task3;

import org.springframework.stereotype.Component;

@Component
public class Bow extends Weapon {
    private int fireDistance;

    public Bow() {
    }

    public Bow(int fireDistance) {
        this.fireDistance = fireDistance;
    }

    public int getFireDistance() {
        return fireDistance;
    }

    public void setFireDistance(int fireDistance) {
        this.fireDistance = fireDistance;
    }
}
