package com.roman.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.roman.hibernate.demo.entity.Student;

public class QueryStudentDemo {

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
			
			// start a transaction
			session.beginTransaction();
			
			// query students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			displayStudents(theStudents);
			
			// query by last name =B
			 theStudents = session.createQuery("from Student s where s.lastName='B'").getResultList();
			
			
			displayStudents(theStudents);
			
			
			
			
			
			
			
			
			
			// Commit the transaction.
			
			session.getTransaction().commit();
			System.out.println("Done!");
			
		}
			finally {
				factory.close();
			}

	}

	private static void displayStudents(List<Student> theStudents) {
		// display students
		for (Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

}
