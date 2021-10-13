package com.hibernate.OneToMany.uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.jdbc.entity.Course;
import com.spring.jdbc.entity.Instructor;
import com.spring.jdbc.entity.InstructorDetail;
import com.spring.jdbc.entity.Reviews;
import com.spring.jdbc.entity.Student;

public class CreateReviewsDemo {

	public static void main(String[] args) {
		
		// create session factory
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")// default hibernate.cfg.xml
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Reviews.class)
								.buildSessionFactory();
		// create session

		Session session = factory.getCurrentSession();
		
		try {
			// start a transaction
			session.beginTransaction();
			
			// create a course
			
			Course course=new Course();
			
			// add some reviews
			
			course.addReview(new Reviews("Zor !!!"));
			course.addReview(new Reviews("Ehh iste !!!"));
			// save course ... and leverage the cascade all
			
			session.save(course);
			// commit transaction
			session.getTransaction().commit();
			
			
			
		} finally {
			session.close();
			factory.close();
		}
		
	}

}
