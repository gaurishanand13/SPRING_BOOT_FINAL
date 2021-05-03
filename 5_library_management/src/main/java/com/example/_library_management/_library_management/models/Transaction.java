package com.example._library_management._library_management.models;
import com.example._library_management._library_management.data.TransactionStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String transactionId = UUID.randomUUID().toString(); // externalId

    /**
     * Note if isIssueOperation is a return operation. Then first we will be calculating
     */
    private int fineAmount;

    /**
     * Note in transaction isIssueOperation will be
     * 1 if this is a book issue operation
     * 0 if this is a book return operation.
     */
    @Column(columnDefinition = "TINYINT(1)")
    private boolean isIssueOperation;

    /**
     * There can be a failed transaction too like if the student tries to issue a book more than the limit / or book is unavailable, etc.
     */
    @Enumerated(value = EnumType.STRING)
    private TransactionStatus transactionStatus;

    @CreationTimestamp
    private Date transactionDate;


    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties("books")
    private Card card;

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties("transactions")
    private Book book;


}
