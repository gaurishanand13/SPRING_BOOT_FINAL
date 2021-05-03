package com.example._library_management._library_management.repositories;
import com.example._library_management._library_management.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import javax.transaction.Transactional;
import java.util.List;


@Transactional
public interface StudentRepository extends JpaRepository<Student, Integer> {

    /**
     *  JPQL - Java Persistence Query Language
     *  Native SQL Query --> columns and tables
     */

    // Note whenever we want to update some earlier record, we always use this
    @Modifying
    @Query("update Student s set s.emailId = :#{#std.emailId}, " +
            "s.name = :#{#std.name}, " +
            "s.age = :#{#std.age} ," +
            "s.country = :#{#std.country} " +
            "where s.id = :#{#std.id}")
    int updateStudentDetails(Student std);


    @Modifying
    @Query("delete from Student s where s.id =:id")
    void deleteCustom(int id);

    @Query("select b from Student b where b.emailId =:mail")
    public List<Student> findStudentByEmail(String mail);

    /**
     * Note - Above queries are different than this. In above query, we are using property name same as we have declared in our code. But in actual
     * case they are stored in different way in our local sql. Example see below -
     * Therefore generally we try to avoid native SQL query as it can create some problems. In above cases, JPA itself converts these properties in the syntax
     * it has stored in our system.
     */
    @Query(value = "select * from student s where s.email_id =:mail", nativeQuery = true)
    public List<Student> findStudentByEmailBySQL(String mail);


}
