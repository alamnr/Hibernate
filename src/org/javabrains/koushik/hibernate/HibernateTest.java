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
		user.setUserId(1);
		user.setUserName("First User");
		user.setAddress("First User Address");
		user.setJoinedDate(new Date());
		user.setDescription("Description of the user goes here");
		
		
		//SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		SessionFactory sessionFactory = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		
	}
	
	

}
