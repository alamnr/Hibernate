package org.javabrains.koushik.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.javabrains.koushik.dto.UserDetails;

public class HibernateTest {
	
	public static void main(String[] args)
	{
		UserDetails user = new UserDetails();
		
		user.setUserName("First User");
		
UserDetails user2 = new UserDetails();
		
		user2.setUserName("Second User");
		
		
		//SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		SessionFactory sessionFactory = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(user2);
		session.getTransaction().commit();
		session.close();
		
		
		
		
	}
	
	

}
