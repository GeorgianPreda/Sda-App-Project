package com.sda.sdaApp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAttendance;
    private boolean isPresent;
    private String comments;

    @ManyToOne
    @JoinColumn(name="idStudent", nullable=false)
    private Person student;
    @ManyToOne
    @JoinColumn(name="idSchedule", nullable=false)
    private Schedule schedule;

    public int getIdAttendance() {
        return idAttendance;
    }

    public void setIdAttendance(int idAttendance) {
        this.idAttendance = idAttendance;
    }

    public boolean isPresent() {
        return isPresent;
    }

    public void setPresent(boolean isPresent) {
        this.isPresent = isPresent;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Person getStudent() {
        return student;
    }

    public void setStudent(Person student) {
        this.student = student;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

}
