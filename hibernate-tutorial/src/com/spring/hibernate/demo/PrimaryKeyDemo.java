package com.spring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.jdbc.entity.Student;

public class PrimaryKeyDemo {

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
					
					// create 3 student object
					Student student = new Student("Elif","Oguz", "elif@elif.com");
					Student student2 = new Student("Batu","Bakir", "batu@batu.com");
					Student student3 = new Student("Mali","Seyran", "syran@syran.com");
						
					// start a transaction
					session.beginTransaction();
					
					// save the student object
					System.out.println("saving the object");
					session.save(student);
					session.save(student2);
					session.save(student3);
					// commit transaction
					session.getTransaction().commit();
					
				} finally {
					factory.close();
				}
	}

}
