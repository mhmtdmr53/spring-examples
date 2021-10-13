package com.hibernate.OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.jdbc.entity.Instructor;
import com.spring.jdbc.entity.InstructorDetail;
import com.spring.jdbc.entity.Student;

public class DeleteInstructorDetailDemo {

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
			int deger=5;
			InstructorDetail instructorDetail=session.get(InstructorDetail.class, deger);
			// print the instructor
			System.out.println("tempInstructorDetail: "+ instructorDetail);
			
			// print the associated instructor
			System.out.println("the associated instructor: "+ instructorDetail.getInstructor());
			// remove the associated object reference
			// break bi-directionl link
			instructorDetail.getInstructor().setInstructorDetail(null); 
			// now let's delete the instructor detail
			session.delete(instructorDetail);
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
