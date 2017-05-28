package com.exemplu.compoundkey;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import org.hibernate.tool.hbm2ddl.SchemaExport;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfiguration configuration = new AnnotationConfiguration();
		configuration.addAnnotatedClass(Accounts.class);
		configuration.configure();
		
		new SchemaExport(configuration).create(true, true);
		
		SessionFactory factory  = configuration.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		session.beginTransaction();
		
		CompoundKey key1 = new CompoundKey(100, 1023);
		Accounts ac = new Accounts();
		ac.setAccountBalance(6025);
		ac.setCompoundKey(key1);
		
		
		session.save(ac);
		session.getTransaction().commit();
	}

}
