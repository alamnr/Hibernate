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

		Address addr1 = new Address();
		addr1.setStreet("First Street");
		addr1.setCity("First City");
		addr1.setState("First State");
		addr1.setPincode("10001");
		addr1.setAddressType("Home");

		Address addr2 = new Address();
		addr2.setStreet("Second Street");
		addr2.setCity("Second City");
		addr2.setState("Second State");
		addr2.setPincode("20002");
		addr2.setAddressType("Office");

		try {
			/*user.addAddress(addr1);
			user.addAddress(addr2);*/
			
			user.getListOfAddresses().add(addr1);
			user.getListOfAddresses().add(addr2);

			/*
			 * SessionFactory sessionFactory = new
			 * Configuration().configure().buildSessionFactory();
			 */
			SessionFactory sessionFactory = new AnnotationConfiguration().configure("hibernate.cfg.xml")
					.buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
