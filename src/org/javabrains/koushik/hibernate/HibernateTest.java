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

		
		
		/*UserDetails user2 = new UserDetails();
		user2.setUserId(5);*/
		
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		/*
		for(int i=0; i<=10;i++){
			UserDetails user = new UserDetails();
			user.setUserName("User- "+i);
			session.save(user);
		}
		*/
		
		/*UserDetails user = (UserDetails) session.get(UserDetails.class, 6);
		System.out.println("User Name- " + user.getUserName());*/
		
		/*UserDetails user = (UserDetails) session.get(UserDetails.class, 6);
		session.delete(user);
		session.delete(user2);*/
		
		UserDetails user = (UserDetails) session.get(UserDetails.class, 4);
		user.setUserName("Updated User");
		//session.update(user);

		session.getTransaction().commit();
		session.close();

		// item = null;

		//user = null;
		//vehicle2 = null;
		//vehicle = null;
		//session = sessionFactory.openSession();
		// item = (Item) session.get(Item.class, 1L);
		//user = (UserDetails) session.get(UserDetails.class, 1);
		//vehicle2 = (Vehicle) session.get(Vehicle.class, 2);
		//vehicle = (Vehicle) session.get(Vehicle.class, 1);
		//session.close();

		// System.out.println("Bid count:"+item.getBids().size());

		// System.out.println("Vehicle count:"+user.getVehicleList().size());

		/*
		 * System.out.println("User Name: " + vehicle.getUser().getUserName());
		 * 
		 * System.out.println("User Name: " + vehicle2.getUser().getUserName());
		 */

		HibernateUtil.shutDown();

	}

}
