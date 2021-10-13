package com.spring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.jdbc.entity.Student;

public class ReadStudentDemo {

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
			Student student = new Student("daggy","dack", "duffy@duck.com");
					
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("saving the object");
			System.out.println(student);
			session.save(student);
			
			// MY NEW CODE	 
			// find out the student's primary key
			System.out.println("saved student. id: "+ student.getId());
			
			// bu commit ile session bitiyor. Baska islem icin yeniden session olusturmak lazim
			session.getTransaction().commit();
			
			
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on the primary key
			System.out.println("\n getting student with id: "+ student.getId());
			Student myStudent= session.get(Student.class, student.getId());
			System.out.println("\n get complete"+ myStudent);
			// commit transaction
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
		
	}

}
