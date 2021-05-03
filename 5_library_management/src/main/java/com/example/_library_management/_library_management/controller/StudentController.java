package com.example._library_management._library_management.controller;


import com.example._library_management._library_management.models.Student;
import com.example._library_management._library_management.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
    @Autowired
    StudentServices studentService;

    @PostMapping("/createStudent")
    public ResponseEntity createStudent(@RequestBody Student student){
        studentService.createStudent(student);
        return new ResponseEntity<>("the student is successfully added to the system", HttpStatus.CREATED);
    }

    // curl -XPUT "127.0.0.1:8080/updateStudent" -d'{"name": "Piyush", "email": "p@gmail.com", id}'
    @PutMapping("/updateStudent")
    public ResponseEntity updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
        return new ResponseEntity<>("student is updated", HttpStatus.ACCEPTED);
    }


    @DeleteMapping("/deleteStudent")
    public ResponseEntity deleteStudent(@RequestParam("id") int id){
        studentService.deleteStudent(id);
        return new ResponseEntity<>("student is deleted", HttpStatus.ACCEPTED);
    }
}
