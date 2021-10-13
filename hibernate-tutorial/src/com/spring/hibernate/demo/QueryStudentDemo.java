package com.spring.hibernate.demo;

import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.jdbc.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")// default hibernate.cfg.xml
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		// create session

		Session session = factory.getCurrentSession();
		
		try {
			
					
			// start a transaction
			session.beginTransaction();
			
			// query students
			
			List<Student> students = session.createQuery("from Student", Student.class).getResultList();
			
			// display the students
			DisplayStudents(students);
			
			// query students: lastName='mali'
			
			students = session.createQuery("from Student s where s.lastName='Oguz'").getResultList();
			System.out.println("Istenilen: \n");
			DisplayStudents(students);
			
			// query students: lastname='doe' OR firstName='mali'
			System.out.println("2. sorgu: \n");
			students= session.createQuery("from Student s where s.lastName='Oguz' OR s.firstName='Mali'").getResultList();
			DisplayStudents(students);
			
			// query students: sonu @batu.com ile bitenler
			
			System.out.println("3. sorgu");
			students= session.createQuery("from Student s where "+" s.email LIKE '@mali.com'").getResultList();
			DisplayStudents(students);
			
			
			// commit transaction
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
		
	}

	private static void DisplayStudents(List<Student> students) {
		for(Student tempStudent : students)
		{
			System.out.println(tempStudent);
			
		}
	}

}
