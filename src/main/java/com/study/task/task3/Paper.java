package com.study.task.task3;

public class Paper {
    public static final String MY_FAVORITE_COLOR = "White";

    private String color;
    private String format;

    public Paper(String color, String format) {
        this.color = color;
        this.format = format;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }

        Paper otherPaper = (Paper) obj;

        if (!this.color.equals(otherPaper.color)) {
            return false;
        }
        if (!this.format.equals(otherPaper.format)) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "Paper{" +
                "color='" + color + '\'' +
                ", format='" + format + '\'' +
                '}';
    }
}
