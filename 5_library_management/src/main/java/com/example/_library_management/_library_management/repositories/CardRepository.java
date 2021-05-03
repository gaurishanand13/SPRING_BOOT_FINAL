package com.example._library_management._library_management.repositories;

import com.example._library_management._library_management.models.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface CardRepository extends JpaRepository<Card,Integer> {

    /**
     * In this query, first we are fetching the card_id of the student from students table using student_it. Then using that card_id
     * we have deactivated that card.
     */
    @Modifying
    @Transactional
    @Query(value = "update card c set c.card_status =:status where c.id in (select card_id from student s where s.id =:student_id)", nativeQuery = true)
    void deactivateCard(int student_id, String status);
}
