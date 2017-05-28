package com.exemplu.ManyToManyMapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;



public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfiguration configuration = new AnnotationConfiguration();
		configuration.addAnnotatedClass(Event.class);
		configuration.addAnnotatedClass(Delegate.class);
		configuration.configure();
		
		new SchemaExport(configuration).create(true, true);
		
		SessionFactory factory  = configuration.buildSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		Delegate d1 = new Delegate();
		d1.setDelegateName("cristina");
		
		Delegate d2 = new Delegate();
		d2.setDelegateName("ionut");
		
		Delegate d3 = new Delegate();
		d3.setDelegateName("stefan");
		
		Delegate d4 = new Delegate();
		d4.setDelegateName("cosmin");
		
		Event e1 = new Event();
		e1.setEventName("java");
		
		Event e2 = new Event();
		e2.setEventName("c#");
		
		e1.getDelegates().add(d1);
		e1.getDelegates().add(d3);
		
		e2.getDelegates().add(d2);
		e2.getDelegates().add(d4);
		
		session.save(d1);
		session.save(d2);
		session.save(d3);
		session.save(d4);
		
		session.save(e1);
		session.save(e2);
		
		session.getTransaction().commit();
		
		
		
	}

}
