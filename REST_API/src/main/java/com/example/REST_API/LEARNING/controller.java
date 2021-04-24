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





    @Autowired
    CONFIGURATION_ANNOTATION config_annotation;


    @Autowired
    PARENT PARENT_TEMP;
    @Autowired
    PARENT PARENT_TEMP_TWO;




    @GetMapping("/second/getPerson")
    public PERSON_TEMP getPerson(){

        /**
         * Since both the objects had the same scope, therefore they have the same address.
         * Also there is another way, we can get access to bean created by spring boot, shown in the 3rd way.
         * Note here s: id of the bean which is by default the name of the class
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

        // ===============================================================================================================================================================

        System.out.println("config_annotation = " + config_annotation); // OUTPUT -  config_annotation = com.example.REST_API.LEARNING.CONFIGURATION_ANNOTATION$$EnhancerBySpringCGLIB$$cf6fde14@50a3e808


        /**
         * Therefore this is another way to create a bean. Instead of directly using @Controller annotation over class, you can use @Bean class over the
         * function returning that class object. Now please note - that function returning the bean, should be inside the class having @Configuration over it.
         * The @Configuration is a marker annotation which indicates that a class declares one or more @Bean methods
         */
        System.out.println("config_annotation getChildren() 1 = " + config_annotation.getChildren()); // OUTPUT - config_annotation getChildren() 1 = com.example.REST_API.LEARNING.CHILDREN@77517292
        System.out.println("config_annotation getChildren() 2 = " + config_annotation.getChildren()); // OUTPUT - config_annotation getChildren() 2 = com.example.REST_API.LEARNING.CHILDREN@77517292




        // The main difference is that now by writing the object as singletype, even if i try to create a new object. Then also it will be same as bean
        // created by spring boot.
        System.out.println("PARENT_TEMP = " + PARENT_TEMP);
        System.out.println("PARENT_TEMP TWO = " + PARENT_TEMP_TWO);
        System.out.println("PARENT_TEMP NEW = " + (new PARENT()));
        /**
         * Output of above -
         * PARENT_TEMP = com.example.REST_API.LEARNING.PARENT@162406f9
         * PARENT_TEMP TWO = com.example.REST_API.LEARNING.PARENT@162406f9
         * PARENT_TEMP NEW = com.example.REST_API.LEARNING.PARENT@7b664f19
         */

        return null;
    }

}
