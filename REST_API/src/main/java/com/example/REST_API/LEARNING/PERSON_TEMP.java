package com.example.REST_API.LEARNING;

import org.springframework.stereotype.Component;

/**
 * Adding @Component adding to it, a bean of this class will be created by spring on its own automatically.
 */
@Component
public class PERSON_TEMP {
    int id;
    private int age;
    private String name;
    private String country;

    public PERSON_TEMP() {
        this.id = 100;
        this.age = 21;
        this.name = "Navdha is love";
        this.country = "India";
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

