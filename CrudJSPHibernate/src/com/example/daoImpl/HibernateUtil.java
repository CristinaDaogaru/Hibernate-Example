package com.example.daoImpl;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {

	private static final SessionFactory sessionFactory;
	
	static{
		try{
			
			sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
			
			
			
		}catch (Throwable e) {
			// TODO: handle exception
			System.err.println("Initial SessionFactory creation failed " + e);
			throw new ExceptionInInitializerError(e);
		}
	}
	
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
		
	}

}
