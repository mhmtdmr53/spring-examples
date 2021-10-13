package com.hibernate.OneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.jdbc.entity.Course;
import com.spring.jdbc.entity.Instructor;
import com.spring.jdbc.entity.InstructorDetail;
import com.spring.jdbc.entity.Student;

public class DeleteCourseDemo {

	public static void main(String[] args) {
		
		// create session factory
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")// default hibernate.cfg.xml
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		// create session

		Session session = factory.getCurrentSession();
		
		try {
			
			
			// start a transaction
			session.beginTransaction();
			
			// get a course object
			int deger=10;
			Course course=session.get(Course.class, deger);
			// delete course
			System.out.println("Deleting.. "+ course);
			session.delete(course);
			
			System.out.println("Done!!");
			// commit transaction
			session.getTransaction().commit();
			System.out.println("deneme");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			// handle the leak issue
			//session.close();
			
			factory.close();
		}
		
	}

}
