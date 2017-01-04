package com.roman.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.roman.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			int studentId =1;
			
			// get a new session transaction and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// Retrieve student based on the id: primary key
			System.out.println("Getting student with id: " + studentId);
			
			Student myStudent = session.get(Student.class, studentId);
			
			System.out.println("Updating student...");
			myStudent.setFirstName("Maria");
			
			
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
			// New code 
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// Updating emails for all students
			
			System.out.println("\nUpdating all emails...\n");
			
			session.createQuery("update Student set email='myemail@email.ru'").executeUpdate();
			
			
			session.getTransaction().commit();
			
		}
			finally {
				factory.close();
			}

	}

}
