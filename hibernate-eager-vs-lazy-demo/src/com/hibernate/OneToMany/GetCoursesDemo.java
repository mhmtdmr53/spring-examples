package com.hibernate.OneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.jdbc.entity.Course;
import com.spring.jdbc.entity.Instructor;
import com.spring.jdbc.entity.InstructorDetail;
import com.spring.jdbc.entity.Student;

public class GetCoursesDemo {

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
			
			// get the instructor detail object
			int id=1;
			Instructor instructor=session.get(Instructor.class, id);
			// print the instructor
			System.out.println("Instructor : "+ instructor);
			
			// print the associated instructor
			System.out.println("the Courses for instructor: "+ instructor.getCourses());
			
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
