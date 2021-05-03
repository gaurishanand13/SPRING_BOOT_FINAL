package com.example._library_management._library_management.controller;


import com.example._library_management._library_management.models.Book;
import com.example._library_management._library_management.services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookServices bookService;

    /**
     * For inserting the book, we just need this much much json, eg -
     * {
     *     "name" : "physics",
     *     "genre" : "PHYSICS",
     *     "author" : {
     *         "id" : 1
     *     }
     * }
     */
    @PostMapping("/createBook")
    public ResponseEntity createBook(@RequestBody Book book){
        bookService.createBook(book);
        return new ResponseEntity<>("the book is added successfully", HttpStatus.CREATED);
    }


    @GetMapping("/getBooks")
    public ResponseEntity getBooks(@RequestParam(value = "genre", required = false) String genre,
                                   @RequestParam(value = "available", required = false, defaultValue = "false") boolean available,
                                   @RequestParam(value = "author", required = false) String author){


        List<Book> bookList = bookService.getBooks(genre, available, author);
        return new ResponseEntity<>(bookList, HttpStatus.OK);

    }
}
