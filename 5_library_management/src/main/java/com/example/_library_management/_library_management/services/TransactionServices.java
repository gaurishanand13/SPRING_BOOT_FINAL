package com.example._library_management._library_management.services;

import com.example._library_management._library_management.data.CardStatus;
import com.example._library_management._library_management.data.TransactionStatus;
import com.example._library_management._library_management.models.Book;
import com.example._library_management._library_management.models.Card;
import com.example._library_management._library_management.models.Transaction;
import com.example._library_management._library_management.repositories.BookRepository;
import com.example._library_management._library_management.repositories.CardRepository;
import com.example._library_management._library_management.repositories.TransactionRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;


@Service
public class TransactionServices {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    CardRepository cardRepository;

    @Autowired
    TransactionRepositary transactionRepository;

    @Value("${books.max_allowed}")
    int max_allowed_books; // It is the maximum number of books a card can issue at the same time.

    @Value("${books.max_allowed_days}")
    int getMax_allowed_days; // It is the maximum number of days a book can be given on lend. After this fine will be applicable.

    @Value("${books.fine.per_day}")
    int fine_per_day;


    public String issueBook(int cardId, int bookId) throws Exception {
        // findById is a method to find object by primary key.
        Book book = bookRepository.findById(bookId).get();
        Card card = cardRepository.findById(cardId).get();

        Transaction transaction = new Transaction();

        transaction.setBook(book);
        transaction.setCard(card);
        transaction.setIssueOperation(true);

        if(book == null || !book.isAvailable()){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Book is either unavailable or not present");
        }

        if(card == null || card.getCardStatus().equals(CardStatus.DEACTIVATED)){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Card is invalid");
        }

        // since we have done fetchType as lazy for books paramter in card. Therefore it won't be fetched
        // automatically, we have to fetch it using getter explicitly.
        if(card.getBooks().size() >= max_allowed_books){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Book limit has reached for this card");
        }

        book.setCard(card);
        book.setAvailable(false);
        List<Book> bookList = card.getBooks();
        bookList.add(book);
        card.setBooks(bookList);

        bookRepository.updateBook(book);
        transaction.setTransactionStatus(TransactionStatus.SUCCESSFUL);
        transactionRepository.save(transaction);

        return transaction.getTransactionId();
    }

    public String returnBook(int cardId, int bookId) throws Exception{

        List<Transaction> transactions = transactionRepository.find(cardId, bookId,TransactionStatus.SUCCESSFUL, true);

        Transaction transaction = transactions.get(transactions.size() - 1);

        Date issueDate = transaction.getTransactionDate();

        long timeIssuetime = Math.abs(System.currentTimeMillis() - issueDate.getTime());

        long no_of_days_passed = TimeUnit.DAYS.convert(timeIssuetime, TimeUnit.MILLISECONDS);

        int fine = 0;
        if(no_of_days_passed > getMax_allowed_days){
            fine = (int)((no_of_days_passed - getMax_allowed_days) * fine_per_day);
        }

        Book book = transaction.getBook();

        book.setAvailable(true);
        book.setCard(null);

        bookRepository.updateBook(book);

        Transaction tr = new Transaction();
        tr.setBook(transaction.getBook());
        tr.setCard(transaction.getCard());
        tr.setIssueOperation(false);
        tr.setFineAmount(fine);
        tr.setTransactionStatus(TransactionStatus.SUCCESSFUL);

        transactionRepository.save(tr);

        return tr.getTransactionId();
    }



}
