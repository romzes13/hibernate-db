package com.roman.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.roman.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

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
					
					// create 3 student objects
					System.out.println("Creating new student objects");
					Student tempStudent1 = new Student("Alex", "Bbro", "bro@email.com");
					Student tempStudent2 = new Student("Paul", "Blah", "alex@email.com");
					Student tempStudent3 = new Student("John", "Foo", "john@email.com");
					
					
					
					
					
					// start a transaction
					session.beginTransaction();
					
					// save the student object
					System.out.println("Saving the student...");
					session.save(tempStudent1);
					session.save(tempStudent2);
					session.save(tempStudent3);
					
					// commit transaction
					session.getTransaction().commit();
					System.out.println("Done!");
					
				}
					finally {
						factory.close();
					}

		
		
		
	}

}
