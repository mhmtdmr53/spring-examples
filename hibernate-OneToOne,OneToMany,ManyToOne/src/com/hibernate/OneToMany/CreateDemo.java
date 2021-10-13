package com.hibernate.OneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.jdbc.entity.Course;
import com.spring.jdbc.entity.Instructor;
import com.spring.jdbc.entity.InstructorDetail;
import com.spring.jdbc.entity.Student;

public class CreateDemo {

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
			
			
			
			// create a Instructor objects
			
			Instructor instructor = new Instructor("Mahmut","Demir", "mali@dmrdmr.com");
			InstructorDetail instructorDetail = new InstructorDetail("http://www.elif2mali.com/youtube", "Mami");
			
			// associate the objects
			instructor.setInstructorDetail(instructorDetail);	
			
			// start a transaction
			session.beginTransaction();
			
			// save the instructor object
			// cascadetype sayesinde instructorDetail da database e kaydediliyor.
			session.save(instructor);
			// commit transaction
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
		
	}

}
