package com.example.REST_API.LEARNING;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

    @Autowired
    ApplicationContext context;

    /**
     * By writing the autowired annotation on it, this object will directly point towards the bean created by springboot as we have used
     * controller annotation over the object.
     */
    @Autowired
    PERSON_TEMP person_temp;

    @Autowired
    PERSON_TEMP person_temp_two;





    @Autowired
    TEACHER_TEMP teacher_temp;

    @Autowired
    TEACHER_TEMP teacher_temp_two;




    @GetMapping("/second/getPerson")
    public PERSON_TEMP getPerson(){

        /**
         * Since both the objects had the same scope, therefore they have the same address.
         * Also there is another way, we can get access to bean created by spring boot, shown in the 3rd way.
         */
        System.out.println("person_temp = " + person_temp); // OUTPUT - person_temp = com.example.REST_API.LEARNING.PERSON_TEMP@3034bce9
        System.out.println("person_temp_two = " + person_temp_two); // OUTPUT - person_temp_two = com.example.REST_API.LEARNING.PERSON_TEMP@3034bce9
        System.out.println("person_temp_final = " + ((PERSON_TEMP) context.getBean("PERSON_TEMP"))); // person_temp_final = com.example.REST_API.LEARNING.PERSON_TEMP@3034bce9

        PERSON_TEMP person_temp_three;
//        System.out.println("person_temp_three = " + person_temp_three); --> This will give an error as person_temp_three is still not initialized, since
//        it is not same as bean created by springboot as it doesn't have @Autowired annotation.



        /**
         *  Therefore in case of scope = "prototype", everytime we declare a new object using @autowired --> a new object is created as it can be clearly
         *  seen --> memory address is different for both objects.
         */
        System.out.println("teacher_temp = " + teacher_temp); // teacher_temp = com.example.REST_API.LEARNING.TEACHER_TEMP@7fc75b3d
        System.out.println("teacher_temp_two = " + teacher_temp_two); // teacher_temp_two = com.example.REST_API.LEARNING.TEACHER_TEMP@94e59cb

        return null;
    }

}
