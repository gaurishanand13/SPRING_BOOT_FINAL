package com.example.my_sql.my_sql;

public class User {
    private int id;
    private String name;
    private String country;
    private int age;
    private String state;

    public User(int id, String name, String country, int age, String state) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.age = age;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
