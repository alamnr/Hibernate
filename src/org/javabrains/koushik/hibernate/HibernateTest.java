package org.javabrains.koushik.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.javabrains.koushik.dto.Address;
import org.javabrains.koushik.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();

		user.setUserName("First User");

		UserDetails user2 = new UserDetails();

		user2.setUserName("Second User");

		Address address = new Address();
		address.setStreet("Street name");
		address.setCity("City Name");
		address.setState("State Name");
		address.setPincode("Pin Code");
		
		Address address2 = new Address();
		address2.setStreet(" Another Street name");
		address2.setCity("Another City Name");
		address2.setState("Another State Name");
		address2.setPincode("Another Pin Code");

		user.setOfficeAddress(address2);
		
		user.setHomeAddress(address2);

		// SessionFactory sessionFactory = new
		// Configuration().configure().buildSessionFactory();
		SessionFactory sessionFactory = new AnnotationConfiguration().configure("hibernate.cfg.xml")
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(user2);
		session.getTransaction().commit();
		session.close();
		
		user = null;
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		user = (UserDetails) session.get(UserDetails.class, 1);
		//System.out.println(user.getAddress().getStreet());
		session.getTransaction().commit();
		session.close();
		
		// Since address is a value type and embedded object 
		// hence it's placed on  first level cache in user_detail table , so the value of address is available after session.close() 
		//System.out.println("Adrress value after session close- "+user.getAddress().getPincode());
	}

}
