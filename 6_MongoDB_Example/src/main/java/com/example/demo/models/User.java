package com.example.demo.models;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "my_user") // --> It is used here in place of @entity in mongodb to let know mongodb --> It has to be converted into a document
public class User {
    private String name;
    private int age;
    private double bmi;
    private Address address;
}
