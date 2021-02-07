# SPRING-BOOT

1)	First Download Intellij Idea (Community Edition). Open this you have to install some java jdk too then.
2)	After that install maven in your mac by running the command – 
```
brew install maven
mvn -version
```


1) For streams, watch this video - https://www.youtube.com/watch?v=1OpAgZvYXLQ
2) For parallel streams and asynchronous programming - https://www.youtube.com/watch?v=0hQvWIdwnw4


SPRING BOOT - https://github.com/piyush5807/JBDL-11
<br>
SPRING PROJECT INITIALIZER - https://start.spring.io/
<br>
SITE TO SEARCH FOR DEPENDENCY - https://mvnrepository.com/
<br>
JFROG - Best website to make our remote repo for our SPRING PROJECTS
<br>
<br>
Frameworks used to develop web application using java - Spring Boot / Spring
<br> 
Difference b/w spring boot and spring - Spring Boot has inbuilt webserver of tomcat but spring doesn't have it. In spring, we have to specifically mention which server we want to use unlike spring boot. So Spring boot somewhat makes our tasks easy of setting up the inbuilt server. Though we can even change the inbuilt server of spring boot too. There are also many dependencies which are present by default.

<br>
Server is hardware machine.
<br>
spring boot starter web - used to download

<br>
There are 2 types of apis - Restful apis and Stateful api
<br>
<br>
Inversion Of Control - It means spring makes the object of a class on its own if we mention it, i.e we don't handle the object lifecycle on our own, spring boot handles it. Eg - in the case of rest controller for a class. 
<br>
<br>
Note - Spring will create objects of those classes which are having @component annotation over it directly or indirectly.
Indirectly means like here @RestController doesn't have @component over it, but in turn it inherits @component.
<br>
<br>
Note - An object of a class created by spring on its own is called as bean.
<br>
<br>
Dispatcher Sovelet - These are the parts which are continously running inside the jetty/tomcat server and listens for the request and whenever it comes, it directs it to required function. Therefore it is just a low level class which continuously runs and listens for request.

<br>
<br>
Dependency Injection - Since we know using @component with some class, spring creates an object of that class automatically. Therefore if we want to use the function of such a bean created by spring, then we can use @Autowired annotation and get access to the object(bean) which was created by the spring.


