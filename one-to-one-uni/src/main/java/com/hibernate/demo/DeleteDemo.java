package com.hibernate.demo;

import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteDemo {

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

            //get instructor by primary key/id
            int theId = 1;
            Instructor tempInstructor = session.get(Instructor.class,theId);

            System.out.println("Found Instructor: "+tempInstructor);
            //Delete the Instructor
            if(tempInstructor != null){
                System.out.println("Deleting : "+tempInstructor);
                //Note : also delete Instructor Detail
                session.delete(tempInstructor);
            }

            // commit transaction
            session.getTransaction().commit();

            // session.close();
            System.out.println("Done!");
        }
        finally {
            factory.close();
        }
    }

}