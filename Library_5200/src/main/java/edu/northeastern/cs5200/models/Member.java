package edu.northeastern.cs5200.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.sql.Date;

@Entity
public class Member extends User {

    private Boolean isUnderThirteen;
    private Boolean isSponsored;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "member_id", referencedColumnName = "id")
    private LibraryCard libraryCard;


    //TODO sponsoredBy



    public Member() {

    }

    public Member(Integer id, String firstName, String lastName, String username, String password, String email,
                  Date dateOfBirth, Boolean isUnderThirteen, Boolean isSponsored) {
        super(id, firstName, lastName, username, password, email, dateOfBirth);
        this.isUnderThirteen = isUnderThirteen;
        this.isSponsored = isSponsored;
    }



    public Boolean getUnderThirteen() {
        return isUnderThirteen;
    }

    public void setUnderThirteen(Boolean underThirteen) {
        isUnderThirteen = underThirteen;
    }

    public Boolean getSponsored() {
        return isSponsored;
    }

    public void setSponsored(Boolean sponsored) {
        isSponsored = sponsored;
    }

    public LibraryCard getLibraryCard() {
        return libraryCard;
    }

    public void setLibraryCard(LibraryCard libraryCard) {
        this.libraryCard = libraryCard;
    }
}
