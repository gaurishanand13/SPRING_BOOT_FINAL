package com.example._library_management._library_management.repositories;
import com.example._library_management._library_management.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
