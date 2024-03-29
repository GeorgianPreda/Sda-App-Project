package com.sda.sdaApp.dao;

import com.sda.sdaApp.model.Classroom;
import com.sda.sdaApp.model.Person;
import com.sda.sdaApp.model.Team;
import com.sda.sdaApp.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ClassroomDao {
    public Classroom getClassroomById(int idClassroom) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Classroom classroom = session.get(Classroom.class, idClassroom);

        session.close();

        return classroom;
    }


    public static List<Classroom> getAllClassrooms() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.createQuery("From Classroom");

        List<Classroom> classroomList = query.list();
        return classroomList;
    }



    public Classroom save(Classroom classroom) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(classroom);
        transaction.commit();
        session.close();

        return classroom;
    }

    public void delete(Classroom classroom) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();

        session.delete(classroom);

        transaction.commit();

        session.close();
    }

    public static void deleteAllClassrooms() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("delete from Classroom");
        query.executeUpdate();

        transaction.commit();
        session.close();
    }
}
