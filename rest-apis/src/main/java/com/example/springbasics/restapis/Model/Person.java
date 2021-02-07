package com.example.springbasics.restapis.Model;

public class Person {
    int id;
    private int age;
    private String name;
    private String country;

    public Person(int id,int age, String name, String country) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
