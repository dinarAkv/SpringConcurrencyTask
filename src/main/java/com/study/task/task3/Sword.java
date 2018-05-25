package com.study.task.task3;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Sword extends Weapon {

    private int length;
    private String steelMark;

    public Sword() {
    }

    public Sword(String name, double cost, int length, String steelMark) {
        super(name, cost);
        this.length = length;
        this.steelMark = steelMark;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getSteelMark() {
        return steelMark;
    }

    public void setSteelMark(String steelMark) {
        this.steelMark = steelMark;
    }
}
