package com.example._library_management._library_management.services;

import com.example._library_management._library_management.models.Card;
import com.example._library_management._library_management.models.Student;
import com.example._library_management._library_management.repositories.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentServices {

    private static Logger logger = LoggerFactory.getLogger(StudentServices.class);

    @Autowired
    CardServices cardService;

    @Autowired
    StudentRepository studentRepository;


    public void createStudent(Student student){
        Card newCard = cardService.createAndReturn(student);
        logger.info("The card for the student {} is created with the details - {}", student, newCard);

    }

    public void updateStudent(Student student){
        studentRepository.updateStudentDetails(student);
    }

    public void deleteStudent(int student_id){
        /**
         * While deleting the student, first we should deactivate the card as it is trying to fetch the card_id from student table
         * using student_id.
         * If we would delete the record of student from student table first, then the first statement will give an error.
         */
        cardService.deactivateCard(student_id);
        studentRepository.deleteCustom(student_id);
    }

}
