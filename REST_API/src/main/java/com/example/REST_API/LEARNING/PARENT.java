package com.example.REST_API.LEARNING;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class PARENT {
    private int id;
    private int age;
    private String name;
    private String country;

    public PARENT(){
        this(10, 10, "Piyush", "India");
        System.out.println("Creating user object");
    }


    public PARENT(int id, int age, String name, String country) {
        this.age = age;
        this.name = name;
        this.country = country;
        this.id = id;
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
