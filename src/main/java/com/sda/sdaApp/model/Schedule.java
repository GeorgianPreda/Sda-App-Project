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
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSchedule;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "idTrainer", nullable = false)
    private Person trainer;
    @ManyToOne
    @JoinColumn(name = "idClassroom", nullable = false)
    private Classroom classroom;
    @ManyToOne
    @JoinColumn(name = "idSubject", nullable = false)
    private Subject subject;
    @ManyToOne
    @JoinColumn(name = "idTeam", nullable = false)
    private Team team;

    @OneToMany(mappedBy="schedule")
    private List<Attendance> attendanceList = new ArrayList<>();

    public int getIdSchedule() {
        return idSchedule;
    }

    public void setIdSchedule(int idSchedule) {
        this.idSchedule = idSchedule;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Person getTrainer() {
        return trainer;
    }

    public void setTrainer(Person trainer) {
        this.trainer = trainer;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
