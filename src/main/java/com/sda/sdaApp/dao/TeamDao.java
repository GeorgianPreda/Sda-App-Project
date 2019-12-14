package com.sda.sdaApp.dao;

import com.sda.sdaApp.model.Person;
import com.sda.sdaApp.model.Team;
import com.sda.sdaApp.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class TeamDao {
    // Data Access Object

    public Team getTeamById(int idTeam) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Team t = session.get(Team.class, idTeam);

        session.close();

        return t;
    }


    public static List<Team> getAllTeams() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.createQuery("From Team");

        List<Team> teamList = query.list();
        return teamList;
    }



    public Team save(Team team) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(team);
        transaction.commit();
        session.close();

        return team;
    }

    public void delete(Person person) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();

        session.delete(person);

        transaction.commit();

        session.close();
    }

    public static void deleteAllTeams() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("delete from Team");
        query.executeUpdate();

        transaction.commit();
        session.close();
    }


}
