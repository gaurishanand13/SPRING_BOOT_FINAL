package com.example._library_management._library_management.services;

import com.example._library_management._library_management.models.Author;
import com.example._library_management._library_management.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServices {

    @Autowired
    AuthorRepository authorRepository;

    public void create(Author author){
        authorRepository.save(author);
    }
}
