package com.example._library_management._library_management.models;
import com.example._library_management._library_management.data.Genre;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    // Since we can't store boolean directly in our mySQL table. Therefore we store boolean as INT in our tables.
    @Column(columnDefinition = "TINYINT(1)")
    private boolean available = true;

    // Our book will belong to one of the enums declared here
    @Enumerated(EnumType.STRING)
    private Genre genre;

    public Book(String name, Genre genre, Author author) {
        this.name = name;
        this.genre = genre;
        this.author = author;
        this.available = true;
    }

    /**
     * Now here we will be declaring all the classes which are linked to this class. Clearly this class is the parent class of
     * transactions but is a child class of author and card.
     */

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties("booksWritten")
    private Author author;

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties("books")
    private Card card;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("book")
    private List<Transaction> transactions;
}
