package com.example._library_management._library_management.repositories;

import com.example._library_management._library_management.data.TransactionStatus;
import com.example._library_management._library_management.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionRepositary extends JpaRepository<Transaction, Integer> {


    /**
     * Basically i want to fetch the last successful issue transaction for a particular book perfomed by a particular card.
     * It is required to determinev the date of issuing a book. So that if ant fine is applicable. It can be applied.
     */
    @Query("select t from Transaction t where t.card.id=:cardId and t.book.id=:bookId and t.isIssueOperation=:isIssue and t.transactionStatus=:status")
    public List<Transaction> find(int cardId, int bookId, TransactionStatus status, boolean isIssue);


}
