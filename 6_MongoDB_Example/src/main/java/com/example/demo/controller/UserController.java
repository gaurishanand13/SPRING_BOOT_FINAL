package com.example.demo.controller;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepositories repository;

    @GetMapping("/getUsers")
    public List<User> getUsers (){
        return repository.findAll();
    }

    @GetMapping("/getUserForName")
    public List<User> getUserForName(@RequestParam("name") String name){
        return repository.findByName(name);
    }

    @PostMapping("/insertUser")
    public User insertUser (@RequestBody User user){
        return repository.save(user);
    }

    @GetMapping("/users/{age}")
    public List<User> getUsersForAge(@PathVariable("age") int age){
        return repository.findUserByAge(age);
    }
}