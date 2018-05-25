package com.study.task.task4;

public class Book {
    private static int beanCreationCounter = 0;

    private String name;
    private int pages;

    public Book() {
        beanCreationCounter++;
    }

    public Book(String name, int pages) {
        this.name = name;
        this.pages = pages;
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

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
