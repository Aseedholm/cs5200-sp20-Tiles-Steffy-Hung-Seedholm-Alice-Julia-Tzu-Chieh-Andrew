package edu.northeastern.cs5200.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.sql.Date;

@Entity(name="books")
public class Book {

    @Id
    private Integer book_id;

    @ManyToOne
    private Author author;

    private String title;
    private Date yearPublished;
    private Genre genre;
    private String ISBN;
    private Integer numPages;

    public Book(){

    }

    public Book(Integer book_id, String title, Author author, Date yearPublished,
                Genre genre, String ISBN, Integer numPages) {
        this.book_id = book_id;
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.genre = genre;
        this.ISBN = ISBN;
        this.numPages = numPages;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Date getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(Date yearPublished) {
        this.yearPublished = yearPublished;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Integer getNumPages() {
        return numPages;
    }

    public void setNumPages(Integer numPages) {
        this.numPages = numPages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_id=" + book_id +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", yearPublished=" + yearPublished +
                ", genre=" + genre +
                ", ISBN='" + ISBN + '\'' +
                ", numPages=" + numPages +
                '}';
    }
}
