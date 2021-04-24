package com.example.my_sql.my_sql.Service;
import com.example.my_sql.my_sql.DBUtils.DbOperations;
import com.example.my_sql.my_sql.Model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private static Logger logger = LoggerFactory.getLogger(UserService.class);
    DbOperations connection;

    // It is known as Constructor dependency injection i.e though we have not declared object of this DbOperations and not even passed to this constructor
    // But when it comes to this line, spring boot will notice that since DbOperations is a bean. It will first create the bean of that class if already not created
    // and pass that bean here to this constructor. In this way, we were not required to create our own bean.
    public UserService(DbOperations operations,@Value("${test.my_prop}") String my_prop){
        this.connection = operations;

        logger.info("operations is {}", operations); // OUTPUT

        // This is the way, we can access variables declared in application.properties file.
        logger.info("prop is {}", my_prop); // OUTPUT
    }

    public void insertUser(User user) throws SQLException {

        String sql = "insert into user(name, country, age) VALUES (\"" + user.getName() + "\", \"" + user.getCountry() + "\", " + user.getAge() + ")";

        Statement statement = connection.getConnection().createStatement();
        int rows_modified = statement.executeUpdate(sql); // Since we are inserting only 1 user, therefore no of users modified is 1.
        // if we would have used executeQuery command, then it would have retuned null as discussed while creating table.

        logger.info("No of users inserted : {}", rows_modified);
    }

    public List<User> getUsers() throws SQLException {

        String sql = "select * from user";

        Statement statement = connection.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        List<User> userList = new ArrayList<>();

        while(resultSet.next()){

            int id = resultSet.getInt(1); // or we can even get the value using the columnName
            String name = resultSet.getString(2);
            String country = resultSet.getString(3);
            int age = resultSet.getInt(4);

            User user = new User(id, name, country, age);
            userList.add(user);
        }

        return userList;

    }

    public User getUser(int id) throws Exception {

        String sql = "select * from user where id = " + id;

        Statement statement = connection.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while(resultSet.next()){

            int record_id = resultSet.getInt(1); // resultSet.getInt("id")
            String name = resultSet.getString(2);
            String country = resultSet.getString(3);
            int age = resultSet.getInt(4);

            User user = new User(record_id, name, country, age);

            return user;
        }

        logger.error("No user found for id {}", id);

//        Therfore instead of returning null, let's throw an exception.
//        return null;

        throw new Exception("No user found");

    }




}
