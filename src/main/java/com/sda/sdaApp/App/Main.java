package com.sda.sdaApp.App;

import com.sda.sdaApp.dao.PersonDao;
import com.sda.sdaApp.dao.TeamDao;
import com.sda.sdaApp.model.Person;
import com.sda.sdaApp.model.Team;
import com.sda.sdaApp.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;


public class Main {

    public static void main(String[] args) {

        initializeData();


        List<Team> teamList = TeamDao.getAllTeams();
        for (Team t : teamList) {
            System.out.println(t);
        }


//        PersonDao.getAllStudents();
        List<Person> personList = PersonDao.getAllStudents();
        for (Person person : personList) {
            System.out.println(person);
        }

        assignStudentsToTeams();

        List<Person> personList2 = PersonDao.getAllStudents();
        for (Person person : personList2) {
            System.out.println(person);
        }
//        clearData();


    }

    private static void initializeData() {
        createTeams();
        createStudents();
    }

    public static void clearData() {
        TeamDao.deleteAllTeams();
        PersonDao.deleteAllStudents();
    }

    private static void createTeams() {
        TeamDao teamDao = new TeamDao();

        for (int i = 1; i <= 3; i++) {
            Team t = new Team();
            t.setName("Grupa " + i);
            teamDao.save(t);
        }
    }

    private static void createStudents() {
        PersonDao personDao = new PersonDao();

        for (int i = 1; i <= 20; i++) {
            Person person = new Person();
            person.setFirstname("Student " + i);
            personDao.save(person);
        }
    }

    private static void assignStudentsToTeams() {
        List<Team> teamList = TeamDao.getAllTeams();
        List<Person> studentList = PersonDao.getAllStudents();

        for (int i = 0; i <=3; i++) {
            Person p = studentList.get(i);
            p.setTeam(teamList.get(0));
            PersonDao.save(p);
        }

        for (int i = 4; i <= 7; i++) {
            Person p = studentList.get(i);
            p.setTeam(teamList.get(1));
            PersonDao.save(p);
        }

        for (int i = 8; i <= 11; i++) {
            Person p = studentList.get(i);
            p.setTeam(teamList.get(2));
            PersonDao.save(p);
        }
    }



}
