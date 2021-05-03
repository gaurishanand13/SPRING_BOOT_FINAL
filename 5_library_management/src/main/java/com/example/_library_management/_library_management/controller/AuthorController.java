package com.example._library_management._library_management.controller;

import com.example._library_management._library_management.models.Author;
import com.example._library_management._library_management.services.AuthorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {
    @Autowired
    AuthorServices authorService;


    @PostMapping("/createAuthor")
    public ResponseEntity createAuthor(@RequestBody Author author){
        authorService.create(author);
        /**
         * Note response entity is used to return response code along with the data which we want to return, we can return array of objects
         * or an object directly in body here.
         */
        return new ResponseEntity<>("the author is successfully added to the system", HttpStatus.CREATED);
    }
}
