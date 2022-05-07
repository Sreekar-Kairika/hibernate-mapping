package com.hibernate.demo;

import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorDetailDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            // start a transaction
            session.beginTransaction();

            //get instructor detail object
            int theId =22;
            InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class,theId);

            //print instructor detail
            System.out.println("theInstructorDetail: "+tempInstructorDetail);

            //print associated instructor
            System.out.println("the associated Instructor "+tempInstructorDetail.getInstructor());

            // commit transaction
            session.getTransaction().commit();

            // session.close();
            System.out.println("Done!");
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        finally {
            // session closing handle leak connection
            session.close();
            factory.close();
        }
    }

}