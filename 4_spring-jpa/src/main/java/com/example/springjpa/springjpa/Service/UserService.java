package com.example.springjpa.springjpa.Service;

import com.example.springjpa.springjpa.Model.User;
import com.example.springjpa.springjpa.Repositary.UserRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Note there are many by default already written queries in spring data jpa. But most commanly used are -
 * 1. findAll --> To fetch all the users.
 * 2. findById(id).get() --> It will return null if that id user doesn't exist
 * 3. save() --> To insert a user
 */

@Service
public class UserService {

    @Autowired
    UserRepositary userRepository;

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User getUser(int id){
        return userRepository.findById(id).get();

    }

    public void insertUser(User user){
        userRepository.save(user);
    }
}
