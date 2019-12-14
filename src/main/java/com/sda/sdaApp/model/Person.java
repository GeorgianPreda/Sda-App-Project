package com.sda.sdaApp.model;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPerson;
    private String firstname;
    private String lastname;
    private Date dateOfBirth;
    private String email;
    private boolean isTrainer;

    @ManyToOne
    @JoinColumn(name = "idTeam", nullable = true)
    private Team team;

    @OneToMany(mappedBy = "student")
    private List<Attendance> attendanceList = new ArrayList<>();

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isTrainer() {
        return isTrainer;
    }

    public void setTrainer(boolean isTrainer) {
        this.isTrainer = isTrainer;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public List<Attendance> getAttendanceList() {
        return attendanceList;
    }

    public void setAttendanceList(List<Attendance> attendanceList) {
        this.attendanceList = attendanceList;
    }

    @Override
    public String toString() {
        return "Person [idPerson=" + idPerson + ", firstname=" + firstname + ", lastname=" + lastname + ", dateOfBirth=" + dateOfBirth + ", email="
                + email + ", isTrainer=" + isTrainer + "]" +team;
    }
}
