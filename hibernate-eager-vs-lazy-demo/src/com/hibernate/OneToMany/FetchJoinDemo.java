package com.hibernate.OneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.spring.jdbc.entity.Course;
import com.spring.jdbc.entity.Instructor;
import com.spring.jdbc.entity.InstructorDetail;
import com.spring.jdbc.entity.Student;

public class FetchJoinDemo {

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
			
			// option 2: Hibernate query with HQL
			
			// get the instructor  object
			int id=1;
			
			Query<Instructor> query= session.createQuery("select i from Instructor i "
							+ "JOIN FETCH i.courses "
							+ "where i.id=:theInstructorId",
							Instructor.class);
			
			// set parameter on query
			query.setParameter("theInstructorId", id);
			
			// execute query
			
			Instructor instructor = query.getSingleResult();
			
			// commit transaction
			session.getTransaction().commit();
			
			session.close();
			// session kapandiktan sonra course ye erisilmiyor
			System.out.println("\n session is closed!! \n");
			System.out.println("the Courses for instructor: "+ instructor.getCourses());
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			
			
			factory.close();
		}
		
	}

}
