package com.example.REST_API.LEARNING;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope("prototype") // spring will not create it explicitly on application startup, it will be created as and when it needs to be used.
public class TEACHER_TEMP {

    private int id;
    private int age;
    private String name;
    private String country;

    public TEACHER_TEMP(){
        this(10, 10, "Piyush", "India");
        System.out.println("Creating user object");
    }


    public TEACHER_TEMP(int id, int age, String name, String country) {
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
