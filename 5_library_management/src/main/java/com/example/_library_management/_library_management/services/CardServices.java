package com.example._library_management._library_management.services;

import com.example._library_management._library_management.data.CardStatus;
import com.example._library_management._library_management.models.Card;
import com.example._library_management._library_management.models.Student;
import com.example._library_management._library_management.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CardServices {

    @Autowired
    CardRepository cardRepository;

    public Card createAndReturn(Student student){
        Card card = new Card();
        card.setStudent(student);
        student.setCard(card);

        /**
         * Since we have made cascading type as all. On saving the card. its children will also be saved automatically in our sql databases.
         * Therefore don't need to save the student explicitly.
         */
        cardRepository.save(card);

        return card;
    }

    public void deactivateCard(int student_id){
        cardRepository.deactivateCard(student_id, CardStatus.DEACTIVATED.toString());
    }
}
