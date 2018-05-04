package org.hibernate.in.action.book.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaValidator;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	
	private static AnnotationConfiguration cfg ;
	
	static{
		try{
			cfg = new AnnotationConfiguration().configure("hibernate.cfg.xml");
			sessionFactory =  cfg.buildSessionFactory();
		}
		catch (Throwable ex) {
		       throw new ExceptionInInitializerError(ex);
		    }
	}
	
	public static SessionFactory getSessionFactory(){
		//Alternatively, you could look up in JNDI here
		return sessionFactory;
	}
	
	public static void validateSchema(){
		new SchemaValidator(new AnnotationConfiguration().configure("hibernate.cfg.xml")).validate();
	}
	
	public static void setNamingStrategy(){
		cfg.setNamingStrategy(new CENamingStrategy());
	}
	
	public static void shutDown(){
		// Close caches and connection pool
		getSessionFactory().close();
	}

}
