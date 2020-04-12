package edu.northeastern.cs5200.models;

import javax.persistence.*;

@Entity
public class BookCopy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Book book;

    private Boolean isAvailable;
    private Integer edition;

    @Enumerated(EnumType.STRING)
    private CurrentCondition cond;


    public BookCopy() {
    }

    public BookCopy(Integer id, Book book, Boolean isAvailable, Integer edition, CurrentCondition condition){
        this.id = id;
        this.book = book;
        this.isAvailable = isAvailable;
        this.edition = edition;
        this.cond = condition;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public CurrentCondition getCondition() {
        return cond;
    }

    public void setCondition(CurrentCondition condition) {
        this.cond = condition;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public Integer getEdition() {
        return edition;
    }

    public void setEdition(Integer edition) {
        this.edition = edition;
    }

}
