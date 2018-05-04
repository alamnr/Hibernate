package org.javabrains.koushik.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.in.action.book.association.dto.Bid;
import org.hibernate.in.action.book.association.dto.Item;
import org.hibernate.in.action.book.inheritance.Table_per_class_with_unions.dto.CreditCard_1;
import org.hibernate.in.action.book.inheritance.Table_per_class_with_unions.dto.DebitCard_1;
import org.hibernate.in.action.book.inheritance.Table_per_concrete_class_with_implicit_polymorphism.dto.CreditCard;
import org.hibernate.in.action.book.inheritance.Table_per_concrete_class_with_implicit_polymorphism.dto.DebitCard;
import org.hibernate.in.action.book.inheritance.single_table.dto.BillingDetails_2;
import org.hibernate.in.action.book.inheritance.single_table.dto.CreditCard_2;
import org.hibernate.in.action.book.inheritance.single_table.dto.DebitCard_2;
import org.hibernate.in.action.book.selfAssociationAndValueType.dto.Category;
import org.hibernate.in.action.book.selfAssociationAndValueType.dto.Message;
import org.hibernate.in.action.book.util.HibernateUtil;
import org.javabrains.koushik.dto.Address;
import org.javabrains.koushik.dto.FourWheeler;
import org.javabrains.koushik.dto.TwoWheeler;
import org.javabrains.koushik.dto.UserDetails;
import org.javabrains.koushik.dto.Vehicle;

public class HibernateTest {

	public static void main(String[] args) {

		/*
		 * An ORM implementation is a complex beast—less complex than an
		 * application server, but more complex than a web application framework
		 * like Struts or Tapes- try
		 */

		// Before opening the hibernate session an object is in Transient state
		// Hibernate not even look on that object

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		// After opening then hibernate session and before closing the hibernate
		// session, an object is in persistent state
		// Hibernate keep looking on that object

		UserDetails user = (UserDetails) session.get(UserDetails.class, 1);
		System.out.println("User Name- " + user.getUserName());

		session.getTransaction().commit();
		session.close();

		// After closing the hibernate session an object is in detached state
		// Hibernate does not keep looking on that object
		//user.setUserName("Updated user name after session close");

		session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(user);

		user.setUserName("Change after to check select before update");
		session.getTransaction().commit();
		session.close();

		HibernateUtil.shutDown();

	}

}
