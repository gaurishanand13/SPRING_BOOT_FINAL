package com.example._library_management._library_management.controller;


import com.example._library_management._library_management.services.TransactionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TransactionController {
    @Autowired
    TransactionServices transactionService;

    @PostMapping("/issueBook")
    public ResponseEntity issueBook(@RequestParam("cardId") int cardId, @RequestParam("bookId") int bookId) throws Exception{
        String externalTransactionId = transactionService.issueBook(cardId, bookId);
        return new ResponseEntity<>("transaction completed, here is your transactionId - " + externalTransactionId, HttpStatus.ACCEPTED);
    }

    @PostMapping("/returnBook")
    public ResponseEntity returnBook(@RequestParam("cardId") int cardId, @RequestParam("bookId") int bookId) throws Exception{
        String externalTransactionId = transactionService.returnBook(cardId, bookId);
        return new ResponseEntity<>("transaction completed, here is your transactionId - " + externalTransactionId, HttpStatus.ACCEPTED);
    }
}
