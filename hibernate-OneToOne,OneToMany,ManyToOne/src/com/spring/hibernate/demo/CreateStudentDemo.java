package com.spring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.jdbc.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")// default hibernate.cfg.xml
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		// create session

		Session session = factory.getCurrentSession();
		
		try {
			
			// use the session object to save Java object
			
			// create a student object
			Student student = new Student("meco","Demir", "meco@meco.com");
					
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("saving the object");
			session.save(student);
			// commit transaction
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
		
	}

}
