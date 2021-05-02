# SPRING-BOOT

1)	First Download Intellij Idea (Community Edition). Open this you have to install some java jdk too then.
2)	After that install maven in your mac by running the command – 
```
brew install maven
mvn -version
```
Or we can install maven manually using https://mkyong.com/maven/install-maven-on-mac-osx/


1) For streams, watch this video - https://www.youtube.com/watch?v=1OpAgZvYXLQ
2) For parallel streams and asynchronous programming - https://www.youtube.com/watch?v=0hQvWIdwnw4


SPRING BOOT GFG REPO - https://github.com/piyush5807/JBDL-11
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
Note - Server is a hardware machine.
<br>
spring boot starter web - used to download initial spring boot dependencies.


<br>
<br>
There are 2 types of apis - Restful (Stateless) apis and Stateful api

### Stateful Api - 
<img width="1381" alt="Screenshot 2021-04-02 at 1 29 32 PM" src="https://user-images.githubusercontent.com/43893611/113439680-a8f1cc00-9408-11eb-9850-7c5074699fb7.jpeg">
<img width="1381" alt="Screenshot 2021-04-02 at 1 29 32 PM" src="https://user-images.githubusercontent.com/43893611/113439700-b444f780-9408-11eb-9931-33b335b5d308.png">
<br>
STATEFUL SERVERS – In this state is maintained in the server, instead of maintaining it in the database. 
Example- A particular website can have multiple servers to handle large number of clients (there can be multiple levels of databases too). When a user logins, load balancer assigns one of the server to that client.
Therefore when user makes a login request,  LB assigns one of the server to that client, then server will make a request to the database to check if this username/password is valid or not. Once it checks that this is valid, then it sends back the token to the server. This token is saved in servers memory in case of stateful servers and then server sends back the token to the client.
Now consider a case after login  User makes some other request (example to view profile/products) , then it will have to pass token along with it. LB will direct it to the server where its token details are stored. Sever will confirm if this token exists or not in it and depending on it, it will give the output. 
But this will fail like for some clients, token is stored in server 1 and if that server1 fails. Then load balancer (LB) will redirect it to some other server like server2. Since there token of these clients is not stored, they have to login again. 
<br>

### Stateless Api - 
<br>
<img width="1384" alt="Screenshot 2021-04-02 at 1 30 30 PM" src="https://user-images.githubusercontent.com/43893611/113439719-bad36f00-9408-11eb-99c9-b6ead6ad48d5.png">
<br>
But this can’t happen in the case of Stateless Servers as these servers store token in database instead of severs. So whenever a client makes a request to the server, server in turn makes a request to db to check whether this token is valid or not and gets the required output from db. Therefore even if server1 fails, LB will redirect them to server2 and server 2 will in turn make a request to db to check if this token is valid or not. Therefore in this case even if some server fails, client will have a smooth functioning and they would not have to login again and again. 
Though stateless servers are slower as compared to stateful servers as they would have to everytime make a request to db to check if this token is valid or not as they are not maintaining client state within the servers. 
But for a large scale applications stateless servers are more reliable and scalable.

<br>



Inversion Of Control - It means spring makes the object of a class on its own if we mention it, i.e we don't handle the object lifecycle on our own, spring boot handles it. Eg - in the case of rest controller for a class. 
<br>
<br>
Note - Spring will create objects of those classes which are having @component annotation over it directly or indirectly.
Indirectly means like here @RestController doesn't have @component over it, but in turn it inherits @component.
<br>
<br>
Note - An object of a class created by spring on its own (i.e Inversion of control) is called as bean.
<br>
<br>
Dispatcher Sovelet - These are the parts which are continously running inside the jetty/tomcat server and listens for the request and whenever it comes, it directs it to required function. Therefore it is just a low level class which continuously runs and listens for request.
<br>
<br>
Dependency Injection - Since we know using @component with some class, spring creates an object of that class automatically. Therefore if we want to use the function of such a bean created by spring, then we can use @Autowired annotation and get access to the object(bean) which was created by the spring.


<br>
<br>
@Scope - using it we can mention the scope of an object created by spring. Eg- @scope("prototyping") will not make the class sigleton, spring will create the object as and when it is used and required.

<br>
<br>
IOC container / Application context - bean created by spring is put into IOC container
<br>
<br>
Check pictures of logging on phone picture


<br>
<br>
PERSISTEN DATABASES - to perform CRUD(CREATE READ UPDATE AND DELETE) operations first we will learn to do with SQL. 
<br>
For SQL project - dependencies used are spring web / my sql driver.
Initializing SQL 
/usr/local/mysql/bin/mysql -uroot -p
password - gaurish13
CREATE DATABASE spring_boot_db;
CREATE USER gaurish_anand_user IDENTIFIED BY 'mypass';
USE spring_boot_db;
GRANT ALL PRIVILEGES ON spring_boot_db.*TO gaurish_anand_user;
<br>
<br>
<br>

### HIBERNATE VS JPA - 
A Hibernate is a Java framework which is used to store the Java objects in the relational database system. It is an open-source, lightweight, ORM (Object Relational Mapping) tool. Basically ek framework jo hume itni lambi queries for create / update / delete, etc likhne se bacha lega. It handles these thing on its own.

A JPA (Java Persistence API) is a dependency of Java which is used to access, manage, and persist data between Java object and relational database. In Spring Boot, JPA is internally using hiberante by default to manage our relational database. 
So, ORM tools like Hibernate, TopLink, and iBatis implements JPA specifications for data persistence. 
<br>
<br>
Therefore 3 dependencies used in hibernate are - 
1. SPRING WEB
2. MY SQL DRIVER
3. SPRING DATA JPA

<br>
<br>
<br>

### Note - 
Instead of making getters and setters for each class in spring boot, we have a dependency named 'lombok' for getters and setters where we can just user @Getters / @Setters dependency to get and set. Code is -
```
<dependency>
	<groupId>org.projectlombok</groupId>
	<artifactId>lombok</artifactId>
</dependency>
```
Some of the annotations provided by lombok is - 
1. @Getter - This provide getters for all fields.
2. @Setter - This provide setters for all fields.
3. @Builder - It is used to build a object without using getters and setters like this - student.builder().name("gaurish").id(1).build();
4. @NoArgsConstructor - provides default constructor
5. @AllArgsConstructor - provides all arugment constructor
6. @ToString - It provides the printing of all arguments of an object by default

<br>
<br>
<br>


### SOME FACTS OF JPA (mySQL ORM)
While using JPA we usually set up the DUAL relationship (i.e Foreign key present in some table which is Primary key of another table)

So note the table which has the foreign key (i.e child table) will use @JoinColumn annotation in child table and parentTable will also map it using mappedBy field in OneToOne annotation. Now here comes 2 things - 
1. OneToOne - Parent Table will be linked to single object of student and vice-verca is also true
2. OneToMany - Parent Object can be linked to a List Of Child Objects but child object will be linked to only one.

### Note 2
Though we get some basic inbuilt SQL queries by default (i.e save , getAll(),etc). But if we want to create advance select/update queries, then that we would have to write on our own.

### Basic points about JPA Cascade Types
The cascade is an optional element defined in @OneToOne, OneToMany, @ManyToOne and @ManyToMany annotations. The main purpose of using JPA Cascade Types is we can perform save or delete for Parent entity then child entity will also be saved or deleted.

### Basic points about JPA Fetch Types
Now we know like in oneToMany relation, one object can be linked to many children objects. Therefore everytime we do 
```
SELECT * FROM parentTable
```
It will fetch all the children objects also of the parentObject. But we may not require these children objects. Maybe we were working on just other properities.
Then in that case too we will be spending a lot of time in fetching all the children. It can make the server slow if we have large data. Therefore what we do is
if we are fetching whole ParentObject , we set FETCH_TYPE = LAZY i.e it won't fetch child objects unless and until we fetch them particulary using their getter of that property. 
But if we want that all the child objects should also be fetched when we are fetching the parentObject, then set FETCH TYPE = EAGER. By default fetch type is eager only i.e all child objects would be fetched.
