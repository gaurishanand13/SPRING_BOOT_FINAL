package com.example._library_management._library_management.services;

import com.example._library_management._library_management.models.Book;
import com.example._library_management._library_management.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServices {
    @Autowired
    BookRepository bookRepository;

    public void createBook(Book book){
        bookRepository.save(book);
    }

    /**
     * We have made a general getBooks method to fetch books - agar koi paramater null bhi hoti hai to bhi chlega ye
     */
    public List<Book> getBooks(String genre, boolean available, String author){
        if(genre != null && author != null){
            return bookRepository.findBooksByGenreAuthor(genre, author, available);
        }else if(genre != null){
            return bookRepository.findBooksByGenre(genre, available);
        }else if(author != null){
            return bookRepository.findBooksByAuthor(author, available);
        }else{
            return bookRepository.findByAvailability(available);
        }


    }
}
