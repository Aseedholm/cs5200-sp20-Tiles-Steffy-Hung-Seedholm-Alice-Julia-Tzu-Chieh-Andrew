package edu.northeastern.cs5200.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Member extends User {

    private Boolean isSponsored;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private LibraryCard libraryCard;

    @ManyToOne
    private Member sponsoredBy;

    @OneToMany(mappedBy="sponsoredBy")
    private Set<Member> recipientsOfSponsorship;

    public Member() {
        this.recipientsOfSponsorship = new HashSet<>();
    }

    public Member(Integer id, String firstName, String lastName, String username, String password, String email,
                  Date dateOfBirth, Boolean isSponsored, Member sponsoredBy,
                  Set<Member> recipientsOfSponsorship) {
        super(id, firstName, lastName, username, password, email, dateOfBirth);
        this.isSponsored = isSponsored;
        this.sponsoredBy = sponsoredBy;
        this.recipientsOfSponsorship = recipientsOfSponsorship;
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

    public Member getSponsoredBy() {
        return sponsoredBy;
    }

    public void setSponsoredBy(Member sponsoredBy) {
        this.sponsoredBy = sponsoredBy;
    }

    public Set<Member> getRecipientsOfSponsorship() {
        return recipientsOfSponsorship;
    }

    public void setRecipientsOfSponsorship(Set<Member> recipientsOfSponsorship) {
        this.recipientsOfSponsorship = recipientsOfSponsorship;
    }

    /**
     * Figures out if the member is under 13 or not.
     * @return True if they're under thirteen, false otherwise.
     */
    public boolean isUnderThirteen() {

        Calendar today = Calendar.getInstance();
        Calendar minDOB = today;
        minDOB.add(Calendar.YEAR, -13);


        // If it is  less than zero, than this date is before the minimum DOB
        if (this.getDateOfBirth().compareTo((minDOB.getTime())) < 0) {

            // Therefore, they are at least 13 years old
            return false;
        }

        // If they  were born after the minimum DOB, they are indeed 13 years old
        return true;

    }


    @Override
    public String toString() {
        return "Member{" +
                "username=" + getUsername() +
                ", isSponsored=" + isSponsored +
                ", libraryCard=" + libraryCard +
                ", sponsoredBy=" + sponsoredBy +
                ", recipientsOfSponsorship=" + recipientsOfSponsorship +
                '}';
    }


    public void addSponsorRecipient(Member recipeint) {
        this.recipientsOfSponsorship.add(recipeint);
    }


}