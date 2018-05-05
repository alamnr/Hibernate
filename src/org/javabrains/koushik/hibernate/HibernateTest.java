package org.javabrains.koushik.hibernate;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
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

import javassist.tools.reflect.Sample;



public class HibernateTest {

	public static void main(String[] args) {

		/*
		 * An ORM implementation is a complex beast—less complex than an
		 * application server, but more complex than a web application framework
		 * like Struts or Tapes- try
		 */

		// named queries is query that consolidate on a particular place

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
        
		// Hibernate provide default first level cache and with in same session for the same object it picks data from cache while calling session.get second time
		
		UserDetails user = (UserDetails) session.get(UserDetails.class, 1);
		user.setUserName("Updated User");
		
		UserDetails user2 = (UserDetails) session.get(UserDetails.class, 1);
		
		session.getTransaction().commit();
		session.close();


		session = sessionFactory.openSession();
		session.beginTransaction();
		
		UserDetails user3 = (UserDetails) session.get(UserDetails.class, 1);
		session.getTransaction().commit();
		session.close();

		HibernateUtil.shutDown();

	}

}
