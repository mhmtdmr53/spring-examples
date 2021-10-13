package com.spring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.jdbc.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")// default hibernate.cfg.xml
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		// create session

		Session session = factory.getCurrentSession();
		
		try {
			
			int tempID=2;
			
			// start a transaction
			session.beginTransaction();
			// get a data from database
			Student student=session.get(Student.class, tempID);
			
			System.out.println("First data before the update: "+ student.getFirstName());
			// update a data
			
			student.setFirstName("Mecit");
			System.out.println("Update is completed!!");
			
			System.out.println("First data after the update: "+ student.getFirstName());
			
			// commit transaction
			session.getTransaction().commit();
			
			
			// 	NEW CODE
			
			session= factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("Guncelleniyor!!");
			session.createQuery("update Student set email='meco@gmail.com' where id='2'")
				.executeUpdate(); // update ve delete islemlerinde kullaniliyor.
			
			
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
		
	}

}
