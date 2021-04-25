package com.example.springjpa.springjpa.Repositary;

import com.example.springjpa.springjpa.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

// Here using UserRepositary interface which extends JpaRepository (entity for which table is to be formed, data type of the primary key)
public interface UserRepositary extends JpaRepository<User, Integer> {


    /**
     * Note by extending JpaRepository, this automatically has many functions like inserting / deleting / get all data / get by primary key
     * and besided this --> we can also write customized queries. But basic queries are handled by JPA Repo on its own.
     */

}
