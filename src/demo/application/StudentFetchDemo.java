package demo.application;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import demo.entity.Student;

public class StudentFetchDemo 
{
	public static void main(String[] args) 
	{
		// create a session factory
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
			// Create a Student object
			System.out.println("Creating a new student object");
			Student theStudent = new Student("Vicky Rog", "Mishra", "debiprasad@gmail.com");
			
			// start the transaction
			Transaction tx = session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the student");
			System.out.println(theStudent);
			session.save(theStudent);
			
			// commit transaction
			tx.commit(); //OR
	// =============================================================================
			// My New Code
			
			// find out the student's primary key id
			System.out.println("Saved Student, Generated Id "+theStudent.getId());
			
			// now get a new session and start a transaction
			session = factory.getCurrentSession();
			Transaction tx1 = session.beginTransaction();
//			session.getTransaction().begin(); // Both ways to start a transaction
			
			// retrieve the student based on primary key
			System.out.println("\nGetting student with id : "+theStudent.getId());
			
			Student student = session.get(Student.class, theStudent.getId());
			
			System.out.println("Get Complete : "+student);
			
			// commit the transaction
			tx1.commit();
			
			System.out.println("Done");
			
		}finally {
			factory.close();
		}
	}
}
