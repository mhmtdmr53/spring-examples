package com.spring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.jdbc.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")// default hibernate.cfg.xml
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		// create session

		Session session = factory.getCurrentSession();
		
		try {
			int deger=2;	
			// start a transaction
			session.beginTransaction();
			// get a data
			Student student= session.get(Student.class, deger);
			System.out.println("this data which has "+deger+". id is going to disapear!!");
			// delete a session
			session.delete(student);
			// commit transaction
			System.out.println("done!!");
			session.getTransaction().commit();
			
			
			
			
			session=factory.getCurrentSession();
			session.beginTransaction();
			
			session.createQuery("delete from Student where id=1")
				.executeUpdate();// bu update ve delete islemlerinde kullaniliyor.
			session.getTransaction().commit();
			
			
			
		} finally {
			factory.close();
		}
		
	}

}
