package com.example.springjpa.springjpa.Model;
import javax.persistence.*;


/**
 *  If we want spring JPA to make this table in our local DB, we have to use this annotation, it tells hibernate that we are going to make a table for this
 *  class in our db.
 *  Note - @Table annotation is not necesarry to use. It is just used if we want to change the table name to something else. By default table name is the
 *  class name.
 */
@Entity
@Table(name = "myUser") // -> while creating this table, JPA (Hibernate) will name it as my_user
public class User {


    /**
     * In table if we want some key to be primary key, then we use @Id annotation over it. Now here comes 2 of Generation Type -
     * 1. IDENTITY - In this Hibernate will give unique auto generated integer to each table.
     * 2. AUTO - In this Hibernate will form 1 comman table in our local database and if like there are 2-3 tables, which are using AUTO in them.
     * Then hibernate will be autogenerating a comman value in all of them and it would not be unique for each table unlike IDENTITY.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String name;

    private String lastName;// lastName -> columnName in our sql table will be last_name

    //In this column name will be nation in sql table
    @Column(name = "nation")
    private String country;

    private int AGE; // For this field column name will age

    /**
     *  Though we have a paramterized constructor, but we still need a default constructor.
     *  Reason - when we do getAllUsers() --> JPA internally works in the same manner as we have done. It fetched values of each column. Then
     *  since it doesn't know --> what is the order of arguments in paramterized constructor. Therefore it first forms an empty object using default
     *  constructor but then uses setters to set the values in them. Therefore if we won't have getters / setters and default constructor. Then we would
     *  be getting an error as hibernate will not be able to work.
     */
    public User() {
    }

    /**
     * But we also need this paramterized constructor as we are passing this object as a json while making request to the controller
     * so it automatically used this paramterized constructor.
     */
    public User(int age, String name, String lastName, String country, int id) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.AGE = age;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAGE() {
        return AGE;
    }

    public void setAGE(int AGE) {
        this.AGE = AGE;
    }
}

