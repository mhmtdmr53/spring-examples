package com.hibernate.OneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.jdbc.entity.Course;
import com.spring.jdbc.entity.Instructor;
import com.spring.jdbc.entity.InstructorDetail;
import com.spring.jdbc.entity.Student;

public class CreateCoursesDemo {

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
			
			int deger=1;
			// get the instructor from db
			
			Instructor instructor=session.get(Instructor.class, deger);
			// create some courses
			
			Course course=new Course("Matematik");
			Course course2=new Course("Fizik");
			// add courses to instructor
			instructor.add(course);
			instructor.add(course2);
			// save the courses
			session.save(course);
			session.save(course2);
			
			// commit transaction
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
		
	}

}
