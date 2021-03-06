package com.roman.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.roman.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// use the session object to save java object
			
			// create a student object
			System.out.println("Creating a new student object");
			Student tempStudent = new Student("Roman", "B", "test@email.com");
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the student...");
			System.out.println(tempStudent);
			session.save(tempStudent);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
			// find out new student's Id: primary key
			System.out.println("Saved student. Generated id: " + tempStudent.getId());
			System.out.println("Don!");
			
			// get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			
			// Retrieve student based on the id: primary key
			System.out.println("\nGetting student with id: " + tempStudent.getId());
			
			Student myStudent = session.get(Student.class, tempStudent.getId());
			
			//Student myStudent = session.get(Student.class, 3);

			System.out.println("Get compleate: " + myStudent);
			
			
			// Commit the transaction.
			
			session.getTransaction().commit();
			System.out.println("Done!");
			
		}
			finally {
				factory.close();
			}

	}

}
