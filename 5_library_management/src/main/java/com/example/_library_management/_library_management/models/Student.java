package com.example._library_management._library_management.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity // It is used to let know JPA that we are going to form a table of this all other annotations are from lombok
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String emailId;

    private String name;
    private int age;
    private String country;


    // Note semi paramterized constructor is difficult to make using lombok --> Therefore i am making it directly
    public Student(String email, String name, int age, String country) {
        this.emailId = email;
        this.name = name;
        this.age = age;
        this.country = country;
    }


    /**
     * These 2 fields will be automatically generated by JPA while inserting data and will be handling on its own. So we can ignore them while
     * making an object of this class. createdOn will contain the time when this student is added to the db and updatedOn will contain the time when this
     * student is updated.
     */
    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;

    /**
     * Note there will be one to one relation b/w student and card as each student will be assigned only 1 card and it will be unique
     * for each student.
     * Now clearly we are using here @JoinColumn here to let know that it is the child of class "Card". Now therfore for every student, there
     * should be a card present in the "Card" table. Otherwise it will be an error.
     *
     * Also we are using @JsonIgnoreProperties i.e ignore property "student" of class table while having this. This is a must, for example
     * we fetch card of a particular student --> Since student also fetches card and in turn card also has a property named student which will in turn fetch card.
     * It will come into infinite loop. Therefore using this, we are telling that ignore property "student" of class card for this object. Therefore in this way
     * it won't try to fetch property student of this card.
     */
    @OneToOne
    @JoinColumn
    @JsonIgnoreProperties("student")
    private Card card;
}
