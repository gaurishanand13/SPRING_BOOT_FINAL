package com.example.REST_API.LEARNING;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller_two {

    private static Logger logger = LoggerFactory.getLogger(controller_two.class);

//    @Autowired
//    Logger logger

    @Autowired
    ApplicationContext context;

    public controller_two() {
        System.out.println("In controller_two constructor " + this);
    }

    @GetMapping("/other/logs")
    public void printSomeLogs(){
        logger.debug("Hi debug");
        logger.warn("Hi warn");
        logger.trace("Hi trace");
        logger.error("Hi error");
        logger.info("Hi info");
    }

}
