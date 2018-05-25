package com.study.task.task3;

public class Person {
    private String name;
    private int age;
    private boolean isMan;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.isMan = true;
    }

    public Person(int age, String name) {
        this.name = name;
        this.age = age + 10;
        this.isMan = true;
    }

    public Person(String name, int age, boolean isMan) {
        this.name = name;
        this.age = age;
        this.isMan = isMan;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }

        Person otherPerson = (Person) obj;

        if (!this.name.equals(otherPerson.name)) {
            return false;
        }
        if (this.age != otherPerson.age) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
