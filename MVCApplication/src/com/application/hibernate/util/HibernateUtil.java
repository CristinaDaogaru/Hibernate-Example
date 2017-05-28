package com.application.hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	static{
		try{
			
			sessionFactory = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
		}catch(Throwable e){
			System.out.println("Initial SessionFactory failed. " + e);
			throw new ExceptionInInitializerError(e);
		}
	}
	public static Session openSession(){
		return sessionFactory.openSession();
	}
}
