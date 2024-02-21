package com.sb.features;

public record Person(String name, int age) {
    public Person withAge(int newAge){
        return new Person(name, newAge);
    }
}
