package com.cats;

public class Cat {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String maullar() {
        return "miau: " + name.toUpperCase();
    }

    public Cat() {
    }
}
