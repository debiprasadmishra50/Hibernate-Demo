package demo.application;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import demo.entity.Student;

public class DeleteStudentDemo 
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
			
			// delete the student
//			System.out.println("Deleting Student : "+student);
//			session.delete(student);
			
			// delete student with id = 2 using HQL
			System.out.println("Deleting student id = 2");
			session.createQuery("delete from Student where id = 2").executeUpdate();
			
			// commit the transaction
			tx.commit();
			System.out.println("Done");
			
		}finally {
			factory.close();
		}
	}
}
