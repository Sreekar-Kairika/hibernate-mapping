package com.hibernate.demo;


import com.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeletePacmanCourseDemo {


    //Delete GTA course
        public static void main(String[] args) {

            // create session factory
            SessionFactory factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Instructor.class)
                    .addAnnotatedClass(InstructorDetail.class)
                    .addAnnotatedClass(Course.class)
                    .addAnnotatedClass(Review.class)
                    .addAnnotatedClass(Student.class)
                    .buildSessionFactory();

            // create session
            Session session = factory.getCurrentSession();

            try {

                // start a transaction
                session.beginTransaction();

                // get the student mary from database

                //get the GTA course from course id
                int courseId = 10;
                Course tempCourse = session.get(Course.class,courseId);

                System.out.println("The course is "+tempCourse);
                System.out.println("Deleting course ");

                session.delete(tempCourse);


                // commit transaction
                session.getTransaction().commit();

                System.out.println("Done!");
            }
            finally {

                // add clean up code
                session.close();

                factory.close();
            }
        }
    }
