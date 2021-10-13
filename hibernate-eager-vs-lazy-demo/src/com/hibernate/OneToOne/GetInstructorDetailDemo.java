package com.hibernate.OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.jdbc.entity.Instructor;
import com.spring.jdbc.entity.InstructorDetail;
import com.spring.jdbc.entity.Student;

public class GetInstructorDetailDemo {

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
			
			
			// start a transaction
			session.beginTransaction();
			
			// get the instructor detail object
			int id=3;
			InstructorDetail instructorDetail=session.get(InstructorDetail.class, id);
			// print the instructor
			System.out.println("tempInstructorDetail: "+ instructorDetail);
			
			// print the associated instructor
			System.out.println("the associated instructor: "+ instructorDetail.getInstructor());
			
			// commit transaction
			session.getTransaction().commit();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			// handle the leak issue
			session.close();
			
			factory.close();
		}
		
	}

}
