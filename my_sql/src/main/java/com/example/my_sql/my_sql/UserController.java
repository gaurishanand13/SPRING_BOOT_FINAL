package com.example.my_sql.my_sql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

//    @Autowired

    @GetMapping("/getUsers")
    public List<User> getUsers(){

        return new ArrayList<User>();
    }

    // This function is to get users with particular id
    @GetMapping("/getUsers")
    public User getUserByID(@RequestParam("id") int id) throws Exception{
        return new User(1,"","",10,"");
    }

    @PostMapping("/insertUser")
    public void insertUser(@RequestBody User user){
        // Here user object will be passed as a json and here jackson mapper automatically converts it into an user object.
        // Here we will insert the user in our mysql database
    }

}
