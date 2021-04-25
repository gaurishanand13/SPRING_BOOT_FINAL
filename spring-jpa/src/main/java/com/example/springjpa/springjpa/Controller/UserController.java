package com.example.springjpa.springjpa.Controller;

import com.example.springjpa.springjpa.Model.User;
import com.example.springjpa.springjpa.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/user")
    public User getUserById(@RequestParam("id") int id) throws Exception{
        return userService.getUser(id);
    }

    // Note we dont't need to pass id to this in our paramters while making a request as it will be auto generated on its own by jpa
    @PostMapping("/user")
    public void createUser(@RequestBody User user){ // Jackson mapper
        userService.insertUser(user);
    }


}