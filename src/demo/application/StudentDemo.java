package demo.application;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import demo.entity.Student;

public class StudentDemo 
{
	public static void main(String[] args) 
	{
		// create a session factory
		
//		Configuration cfg = new Configuration();
//		cfg.configure("hibernate.cfg.xml"); //we can simply say cfg.configure() and it will look for the file in your classpath by default
//		cfg.addAnnotatedClass(Student.class);
//		SessionFactory factory = cfg.buildSessionFactory();
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		// create a session
		Session session = factory.getCurrentSession(); // using this will automatically close the session
//		Session session = factory.openSession(); // for this you have to manually close the session
		
		try {
			// Create a Student object
			System.out.println("Creating a new student object");
			Student theStudent = new Student("Debi Prasad", "Mishra", "debiprasad@gmail.com");
			
			// start the transaction
			Transaction tx = session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the student");
			session.save(theStudent);
			
			// commit transaction
			tx.commit(); //OR
//			session.getTransaction().commit(); // either of them will work
			System.out.println("Done");
			
		}finally {
			factory.close();
		}
	}
}
