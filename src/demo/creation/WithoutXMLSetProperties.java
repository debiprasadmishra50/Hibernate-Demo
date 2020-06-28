package demo.creation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class WithoutXMLSetProperties {

	private static SessionFactory getSessionFactory() {
		
		// create configuration using hibernate API
		Configuration configuration = new Configuration();
		configuration.setProperty("connection.driver_class", "com.mysql.cj.jdbc.Driver");
		configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost/test");
		configuration.setProperty("hibernate.connection.username", "root");
		configuration.setProperty("hibernate.connection.password", "mysql");
		configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		configuration.setProperty("current_session_context_class", "thread");
		configuration.setProperty("show_sql", "true");
		configuration.setProperty("format_sql", "true");
		configuration.setProperty("format_sql", "true");
		configuration.setProperty("connection.pool_size", "1");
		configuration.setProperty("hbm2ddl.auto", "update");
		
		return configuration.buildSessionFactory();
	}

	public static void main(String[] args) {
		// getting session factory
		SessionFactory sessionFactory = getSessionFactory();
		System.out.println("Session factory object created : " + sessionFactory);
		Session session = sessionFactory.openSession();
		try {
			System.out.println("Session object created : " + session);
		
			Transaction tx = session.beginTransaction();
			// We can use this session object for doing CRUD (inserting,
			// updating and deleting rows)
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}
