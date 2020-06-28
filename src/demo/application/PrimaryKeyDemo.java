package demo.application;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import demo.entity.Student;

// In POJO Student.java class @GeneratedValue(strategy = GenerationType.IDENTITY) added over Id

public class PrimaryKeyDemo 
{
	public static void main(String[] args) 
	{
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		// create a session
		Session session = factory.getCurrentSession(); 
		
		try {
			// Create 3 Student objects
			System.out.println("Creating 3 Student objects");
			Student theStudent1 = new Student("Debi Prasad", "Mishra", "debiprasad@gmail.com");
			Student theStudent2 = new Student("Debi", "Mishra", "debi@gmail.com");
			Student theStudent3 = new Student("Debi", "Vicky", "debi1234@gmail.com");
			
			// start the transaction
			Transaction tx = session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the students");
			session.save(theStudent1);
			session.save(theStudent2);
			session.save(theStudent3);
			
			
			tx.commit(); 
			System.out.println("Done");
			
		}finally {
			factory.close();
		}
	}
}
