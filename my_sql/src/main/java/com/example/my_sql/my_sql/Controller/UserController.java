package com.example.my_sql.my_sql.Controller;
import com.example.my_sql.my_sql.Model.User;
import com.example.my_sql.my_sql.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/getUsers")
    public List<User> getUsers() throws SQLException {
        return userService.getUsers();
    }

    // This function is to get users with particular id
    @GetMapping("/getUsersByID")
    public User getUserByID(@RequestParam("id") int id) throws Exception{
        return userService.getUser(id);
    }

    @PostMapping("/insertUser")
    public void insertUser(@RequestBody User user) throws SQLException {
        // Here user object will be passed as a json and here jackson mapper automatically converts it into an user object.
        // Here we will insert the user in our mysql database
        userService.insertUser(user);
    }

}
