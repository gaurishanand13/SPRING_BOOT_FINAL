package com.example.springbasics.restapis.Controller;
import com.example.springbasics.restapis.Model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SecondController {

    @Autowired
    Person person;

    @GetMapping("/second/getPerson")
    public Person getPerson(){
        System.out.println(person);
        return person;
    }

}
