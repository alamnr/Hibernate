package org.javabrains.koushik.hibernate;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
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

		

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		
		//Query query = session.createQuery("from UserDetails ");
		
		//Query query = session.createQuery("select userName from UserDetails ");
		
		Query query = session.createQuery("select new map(userId,userName) from UserDetails ");
		
		Query query2 = session.createQuery("select max(userId) from UserDetails ");
		
		query.setFirstResult(5); // select from row number -5
		query.setMaxResults(2);
		
		//List<UserDetails> users = (List<UserDetails>)query.list();
		
		//List<String> userNames = (List<String>)query.list();
		
		List<Map<String,String>> users = (List<Map<String,String>>)query.list();
		
		int result = (int) query2.uniqueResult();
		
		session.getTransaction().commit();
		session.close();

//		System.out.println("Size of list - "+ users.size());
		
		System.out.println("Size of list - "+ result);
		
		for (Map<String,String> map: users){
			System.out.println(map);
		}

		HibernateUtil.shutDown();

	}

}
