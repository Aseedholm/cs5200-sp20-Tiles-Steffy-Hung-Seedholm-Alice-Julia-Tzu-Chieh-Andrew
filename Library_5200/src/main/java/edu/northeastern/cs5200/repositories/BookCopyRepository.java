package edu.northeastern.cs5200.repositories;

import edu.northeastern.cs5200.models.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface BookCopyRepository extends CrudRepository<BookCopy, Integer> {


    /*
    select book_copy.dtype, book_copy.id, member_id, book.title
    from book_copy, leger_entry, book
    where book_copy.id = leger_entry.book_copy_id
    and book_copy.book_id = book.id;
     */


    @Query("SELECT bookCopy, books.title AS title, legerEntry.dateBorrowed AS dateBorrowed " +
            "FROM LegerEntry legerEntry, Book books, BookCopy bookCopy " +
            "WHERE legerEntry.id.memberId = :memberId " +
            "AND legerEntry.id.bookCopyId = bookCopy.id " +
            "AND bookCopy.book = books")
    Set<Object[]> findCheckedOutBooksAllTime(Integer memberId);

    @Query("SELECT bookCopy, books.title AS title, legerEntry.dateBorrowed AS dateBorrowed " +
            "FROM LegerEntry legerEntry, Book books, BookCopy bookCopy " +
            "WHERE legerEntry.id.memberId = :memberId " +
            "AND legerEntry.id.bookCopyId = bookCopy.id " +
            "AND bookCopy.book = books " +
            "AND legerEntry.dateReturned IS null")
    Set<Object[]> findCheckedOutBooksCurrently(Integer memberId);


//    @Query("SELECT bookCopy, books.title AS title, legerEntry.dateBorrowed AS dateBorrowed " +
//            "FROM LegerEntry legerEntry, Book books, BookCopy bookCopy " +
//            "WHERE legerEntry.id.memberId = :memberId " +
//            "AND legerEntry.id.bookCopyId = bookCopy.id " +
//            "AND bookCopy.book = books")

}
