package edu.northeastern.cs5200.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Author author;

    private String title;
    private Date yearPublished;
    private Genre genre;

    @OneToMany(mappedBy = "book", fetch = FetchType.EAGER)
    private Set<BookCopy> bookCopies;

    @Column(unique=true)
    private String ISBN;

    public Book(){

    }

    public Book(Integer id, String title, Author author, Date yearPublished,
                Genre genre, String ISBN, Set<BookCopy> bookCopies) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.genre = genre;
        this.ISBN = ISBN;
        this.bookCopies = bookCopies;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<BookCopy> getBookCopies() {
        return bookCopies;
    }

    public void setBookCopies(Set<BookCopy> bookCopies) {
        this.bookCopies = bookCopies;
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_id=" + id +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", yearPublished=" + yearPublished +
                ", genre=" + genre +
                ", ISBN='" + ISBN + '\'' +
                '}';
    }
}
