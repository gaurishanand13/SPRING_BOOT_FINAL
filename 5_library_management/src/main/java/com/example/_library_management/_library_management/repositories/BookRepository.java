package com.example._library_management._library_management.repositories;

import com.example._library_management._library_management.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import javax.transaction.Transactional;
import java.util.List;

/**
 *  Note @transaction is used to let know the hibernate that transaction is allowed in this table i.e we can peform update/delete operations on this entity
 * 	otherwise by default JPA/hibernate doesn't allow us to perform update/delete operations.
 */
@Transactional
public interface BookRepository extends JpaRepository<Book,Integer> {

    /**
     * This query will find all the available books of a particular author
     */
    @Query("select b from Book b where b.available =:availability and b.author in (select a from Author a where a.name =:author_name)")
    List<Book> findBooksByAuthor(String author_name, boolean availability);

    /**
     * This query will find all the available books of a particular genre
     */
    @Query("select b from Book b where b.genre =:genre and b.available =:available")
    List<Book> findBooksByGenre(String genre, boolean available);

    /**
     * This query will find all the available books of a particular genre written with author whose name is given
     */
    @Query("select b from Book b where b.available =:available and b.genre =:genre and b.author in (select a from Author a where a.name =:author_name)")
    List<Book> findBooksByGenreAuthor(String genre, String author_name, boolean available);

    /**
     * This query will find all the available books
     */
    @Query(value = "select * from book b where b.available =:availabilty", nativeQuery = true)
    List<Book> findByAvailability(boolean availabilty);


    /**
     * This query will be invoked everytime if an issue / return transaction happen on a particular book. Example
     * issue Transaction - Then we have to update this book by marking it unavailable now and we also need to update the card of a particlar student who has issued this book.
     * return Transaction - Then we have to update this book by marking it available now and we also need to update the card of this book as NULL as no one has issued it till now.
     */
    @Modifying
    @Query("update Book b set b.available =:#{#book.available}, b.card =:#{#book.card} where b.id =:#{#book.id}")
    int updateBook(Book book);
}
