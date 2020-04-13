package edu.northeastern.cs5200.models;

import javax.persistence.Entity;
import java.sql.Date;


@Entity
public class Librarian extends User {

    private Date dateHired;
    private Boolean hasW2OnFile;

    public Librarian() {
       super();
    }

    public Librarian(Integer id, String firstName, String lastName, String username, String password, String email,
                     Date dateOfBirth, Date dateHired, Boolean hasW2OnFile) {
        super(id, firstName, lastName, username, password, email, dateOfBirth);
        this.dateHired = dateHired;
        this.hasW2OnFile = hasW2OnFile;
    }


    public Date getDateHired() {
        return dateHired;
    }

    public void setDateHired(Date dateHired) {
        this.dateHired = dateHired;
    }

    public Boolean getHasW2OnFile() {
        return hasW2OnFile;
    }

    public void setHasW2OnFile(Boolean hasW2OnFile) {
        this.hasW2OnFile = hasW2OnFile;
    }
}
