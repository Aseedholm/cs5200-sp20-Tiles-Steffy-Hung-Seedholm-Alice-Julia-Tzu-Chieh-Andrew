package edu.northeastern.cs5200.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class LibraryCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(mappedBy = "libraryCard")
    private Member member;


    private Date expirationDate;




}
