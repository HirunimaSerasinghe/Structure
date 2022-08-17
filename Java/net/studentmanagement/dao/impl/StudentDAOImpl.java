package net.studentmanagement.dao.impl;

import net.studentmanagement.dao.StudentDAO;
import net.studentmanagement.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public StudentDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void saveStudent(Student student) {

        Session session = this.getSession();
        session.persist(student);

//        Transaction transaction = null;
        /*try (Session session = getSession()) {
//            transaction = session.beginTransaction();
            session.save(student);
//            transaction.commit();
        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
            e.printStackTrace();
        }*/
    }

    @Override
    public void updateStudent(Student student) {

        Session session = this.getSession();
        session.update(student);

//        Transaction transaction = null;
//        try (Session session = getSession()) {
//            transaction = session.beginTransaction();
//            session.update(student);
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            e.printStackTrace();
//        }
    }

    @Override
    public void deleteStudent(int id) {

        Session session = this.getSession();
        Student student = (Student) session.load(Student.class, id);
        if (null != student) {
            session.delete(student);
        }

        /*Transaction transaction = null;
        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            Student student = session.get(Student.class, id);
            if (student != null) {
                session.delete(student);
                System.out.println("user is deleted");
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }*/
    }

    @Override
    public Student getStudent(int id) {

        Session session = this.getSession();
        Student student = (Student) session.load(Student.class, id);
        return student;

        /*Transaction transaction = null;
        Student student = null;
        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            student = session.get(Student.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return student;*/
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Student> getAllStudent() {

        Session session = this.getSession();
        List<Student> studentList = session.createQuery("from Student").list();
        return studentList;

        /*Transaction transaction = null;
        List<Student> listOfStudents = null;
        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM Student");
            listOfStudents = query.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfStudents;*/
    }

}
//commit