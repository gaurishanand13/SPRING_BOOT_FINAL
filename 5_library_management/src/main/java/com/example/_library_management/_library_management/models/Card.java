package com.example._library_management._library_management.models;
import com.example._library_management._library_management.data.CardStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
@Entity
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;

    /**
     * It is a type of enum which can have 2 values i.e ACTIVATED / UNACTIVATED. Whenever we want to delete some student from table. Though we will delete his
     * record from student table but his record in card table will be there so that his/her transactions can be tracked later on if required. Therefore on deleting
     * a student card will be turned deactived. This is how this property will be helpful in managing the card of students.
     */
    @Enumerated(value = EnumType.STRING)
    private CardStatus cardStatus;

    public Card(){
        // As whenever a new card is made --> Initially it will be active only.
        this.cardStatus = CardStatus.ACTIVATED;
    }

    /**
     * Now here i will be declaring children table of this card, so that we can fetch all these children too whenever we want to fetch
     * all the books issued by a particular card or we want to see all the transactions done by a particular card.
     *
     * Note all these tables will be children table is a part of design --> You can do opposite too i.e make this as a children table.
     * But we can't make it a child of student table because on deleting a student, a tuple would not have that the primary key present in
     *
     * mappedBy contains the property name in child table which will be the foreign key of that table i.e that property should be for sure
     * present in this table.
     */
    @OneToOne(mappedBy = "card", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("card")
    private Student student;

    @OneToMany(mappedBy = "card", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("card")
    private List<Book> books;

    @ManyToMany(mappedBy = "card", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("card")
    private List<Transaction> transactions;


}
