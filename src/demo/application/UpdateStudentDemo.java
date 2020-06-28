package demo.application;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import demo.entity.Student;

public class UpdateStudentDemo 
{
	public static void main(String[] args) 
	{
		// create a session factory
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
			Transaction tx = session.beginTransaction();
//			session.getTransaction().begin(); // Both ways to start a transaction
			
			int studentId = 1;
			
			// retrieve the student based on primary key : id
			System.out.println("\nGetting student with id : "+studentId);
			
			Student student = session.get(Student.class, studentId);
			
			System.out.println("Updating Student");
			student.setFirstName("Rog Vicky");
			
			// commit the transaction
			tx.commit();
			
			// NEW CODE
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// Update Email for everyone
			System.out.println("Updating email for all students");
			session.createQuery("update Student set email = 'debiprasadmishra50@gmail.com'").executeUpdate();
			
			session.getTransaction().commit(); 
			
			System.out.println("Done");
			
		}finally {
			factory.close();
		}
	}
}
