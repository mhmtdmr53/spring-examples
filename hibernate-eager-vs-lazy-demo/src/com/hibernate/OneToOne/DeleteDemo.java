package com.hibernate.OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.jdbc.entity.Instructor;
import com.spring.jdbc.entity.InstructorDetail;
import com.spring.jdbc.entity.Student;

public class DeleteDemo {

	public static void main(String[] args) {
		
		// create session factory
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")// default hibernate.cfg.xml
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		// create session

		Session session = factory.getCurrentSession();
		
		try {
			
			int deger=2;
			
			
			// start a transaction
			session.beginTransaction();
			Instructor instructor= session.get(Instructor.class, deger);
									
			// delete the instructors
			// also delete other object instructorDetail
			session.delete(instructor);
			
			// commit transaction
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
		
	}

}
