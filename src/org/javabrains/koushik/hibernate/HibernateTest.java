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
import org.javabrains.koushik.dto.UserDetails;
import org.javabrains.koushik.dto.Vehicle;

public class HibernateTest {

	public static void main(String[] args) {
		
		
		   UserDetails user = new UserDetails();
		   user.setUserName("First User");
		   
		   Vehicle vehicle = new Vehicle(); 
		   vehicle.setVehicleName("Car");
		   
		   Vehicle vehicle2 = new Vehicle(); 
		   vehicle2.setVehicleName("Zeep");
		  
		   user.getVehicleList().add(vehicle);
		   user.getVehicleList().add(vehicle2);
		  
		   vehicle.getUsers().add(user); 
		   vehicle2.getUsers().add(user);
		 
		
		// Bidirectional Association (OneToMany and ManyToOne)

		/*
		 * Message message = new Message(); message.setText("Abc"); Message
		 * newMessage = new Message(); newMessage.setText("test");
		 * message.setNextMessage(newMessage);
		 */

		Category aParent = new Category();
		aParent.setName("Parent");
		Category aChild = new Category();
		aChild.setName("Child");
		aParent.addChildCategory(aChild);

		/*
		 * // Table per concrete class with implicit polymorphism CreditCard cc
		 * = new CreditCard(); cc.setOwner("Khelapi");
		 * cc.setNumber("111-222-333");
		 * 
		 * DebitCard dc = new DebitCard(); dc.setOwner("Rin");
		 * dc.setNumber("444-555-666");
		 */
/*
		// Table per concrete class with implicit polymorphism
		CreditCard_1 cc = new CreditCard_1();
		cc.setOwner("Khelapi");
		cc.setNumber("111-222-333");

		DebitCard_1 dc = new DebitCard_1();
		dc.setOwner("Rin");
		dc.setNumber("444-555-666");
*/
		

		// Single Table
		/* 
		
		CreditCard_2 cc = new CreditCard_2();
		cc.setOwner("Khelapi");
		cc.setNumber("111-222-333");

		DebitCard_2 dc = new DebitCard_2();
		dc.setOwner("Rin");
		dc.setNumber("444-555-666");
*/
		// Bidirectional Association (OneToMany and ManyToOne)
		
		/*Bid bid = new Bid();
		bid.setAmount(30);

		Bid bid_2 = new Bid();
		bid_2.setAmount(130);
		
		Item item = new Item();
		
		item.setItemName("Laptop");
		item.addBid(bid);
		item.addBid(bid_2);*/
		
		
		/*
		 * SessionFactory sessionFactory = new
		 * AnnotationConfiguration().configure("hibernate.cfg.xml")
		 * .buildSessionFactory();
		 */
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

	/*	
		session.save(item);
		session.save(bid);
		session.save(bid_2);*/
		
		//session.save(cc);
		//session.save(dc);

		// session.save(aChild);
		// session.save(aParent);
		// session.save(message);
		 session.save(user);
		 session.save(vehicle);
		 session.save(vehicle2);
		session.getTransaction().commit();
		session.close();
		
		//item = null;
		
		user = null;
		session = sessionFactory.openSession();
		//item = (Item) session.get(Item.class, 1L);*/
		user = (UserDetails) session.get(UserDetails.class, 4);
		session.close();
		
		//System.out.println("Bid count:"+item.getBids().size());
		
		System.out.println("Vehicle count:"+user.getVehicleList().size());

		HibernateUtil.shutDown();

	}

}
