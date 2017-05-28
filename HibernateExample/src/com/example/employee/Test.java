package com.example.employee;


import java.sql.*;
import java.util.GregorianCalendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class Test {

	public static void main(String[] args) {

		AnnotationConfiguration configuration = new AnnotationConfiguration();
		configuration.addAnnotatedClass(Employee.class);
		configuration.configure();
		
	//	new SchemaExport(configuration).create(true, true);
		
		SessionFactory factory  = configuration.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		session.beginTransaction();
		
		Employee em = new Employee();
		em.setName("Cristina Daogaru");
		em.setEmail("cristina@bla");
		em.setPassword("blabla");
		em.setPermanent(true);
		em.setJoinDate(new GregorianCalendar(2017,05,31));
		em.setLoginTime(Date.valueOf("2017-06-01"));
		
		session.save(em);
		
		Employee em1 = new Employee();
		em1.setName("Ionut Enache");
		em1.setEmail("ionut@bla");
		em1.setPassword("blabla");
		em1.setPermanent(true);
		em1.setJoinDate(new GregorianCalendar(2017,05,31));
		em1.setLoginTime(Date.valueOf("2017-06-01"));
		
		session.save(em1);
		
		session.getTransaction().commit();
	}

}
