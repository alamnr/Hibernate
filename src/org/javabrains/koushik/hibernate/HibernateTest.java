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
        
		// In order to avoid sql injection attack we use parameter binding  
		
		// String userIdParam = " 5 or 1=1 ";
		
		String userIdParam = " 5 ";
		String userName ="User- 10";
		
		/*Query query = session.createQuery("from UserDetails where userId > ?  and userName = ?" );
		query.setInteger(0, Integer.parseInt(userIdParam.trim()));
		query.setString(1, userName);*/
		
		Query query = session.createQuery("from UserDetails where userId > :userId  and userName = :userName" );
		query.setInteger("userId", Integer.parseInt(userIdParam.trim()));
		query.setString("userName", userName);
		
		List<UserDetails> users = (List<UserDetails>)query.list();
		
		session.getTransaction().commit();
		session.close();

//		System.out.println("Size of list - "+ users.size());
		
		
		for (UserDetails user: users){
			System.out.println(user.getUserName());
		}

		HibernateUtil.shutDown();

	}

}
