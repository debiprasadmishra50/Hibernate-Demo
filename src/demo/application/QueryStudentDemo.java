package demo.application;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import demo.entity.Student;

public class QueryStudentDemo 
{
	public static void main(String[] args) 
	{
		// create a session factory
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		// create a session
//		Transaction tx = factory.getCurrentSession().beginTransaction();
//		factory.getCurrentSession().getTransaction().begin();
//		Session session = factory.openSession();
		Session session = factory.getCurrentSession();
		
		try {
			// start the transaction
			Transaction tx = session.beginTransaction();
			
			// query the students
//			List<Student> students = session.createQuery("from Student").getResultList();
//			List<Student> students = session.createQuery("from Student s where s.lastName = 'Mishra'").getResultList();
//			List<Student> students = session.createQuery("from Student s where s.lastName = 'Mishra'" + " OR s.firstName = 'Vicky'").getResultList();
			List<Student> students = session.createQuery("from Student s where" + " s.email LIKE '%gmail.com'").getResultList(); // % wild-card parameter : ends with gmail.com
			
			//display the students
			for (Student student : students) {
				System.out.println(student);
			}
			
			// commit transaction
			tx.commit(); 
			System.out.println("Done");
			
		}finally {
			factory.close();
		}
	}
}
