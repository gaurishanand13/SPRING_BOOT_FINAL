package com.example.my_sql.my_sql;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.sql.*;

/**
 * Since we want that an object of this class should be made automatically whenever this server starts, therefore we have used
 * @Component over it.
 */
@Component
public class DbOperations {

    private static Connection connection;
    private static Logger logger = LoggerFactory.getLogger(DbOperations.class);

    public Connection getConnection() throws SQLException {

        if(connection==null){
            /**
             * Note by default mysql server runs locally on port 3306. We can even change this port while installing.
             * jdbc - Java database connectivity
             * jdbc(java) is a protocol which is used by any java application to connect with mysql server
             */
            logger.info("Getting the connection from driver manager");
            String db_name = "spring_boot_db";

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db_name, "gaurish_anand_user","mypass");
        }
        createTable();
        return connection;
    }

    private void createTable() throws SQLException {

        String sql = "CREATE TABLE IF NOT EXISTS USER(id INT primary key auto_increment, name VARCHAR(30), country VARCHAR(30), age INT)";
        Statement statement = connection.createStatement();
        ResultSet result  = statement.executeQuery(sql); // This will return nothing for commands like create table / update. But for select commands it will
        // return the selected rows.
        logger.info("Result of create operation is {}",result);
    }
}
