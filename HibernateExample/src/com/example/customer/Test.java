package com.example.customer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import org.hibernate.tool.hbm2ddl.SchemaExport;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfiguration configuration = new AnnotationConfiguration();
		configuration.addAnnotatedClass(Customer.class);
		configuration.configure();
		
		new SchemaExport(configuration).create(true, true);
		
		SessionFactory factory  = configuration.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		session.beginTransaction();
		
		Customer em = new Customer();
		em.setName("Cristina Daogaru");
		em.setAddress("Craiova");
		em.setCredtScore(548);
		em.setRewardPoints(15826);
		
		session.save(em);
		session.getTransaction().commit();
	}

}
