package com.exemplu.oneToOneMapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class Test {

	public static void main(String[] args) {
		AnnotationConfiguration configuration = new AnnotationConfiguration();
		configuration.addAnnotatedClass(Person.class);
		configuration.addAnnotatedClass(PersonDetail.class);
		configuration.configure();
		
		new SchemaExport(configuration).create(true, true);
		
		SessionFactory factory  = configuration.buildSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		PersonDetail persDetail = new PersonDetail();
		persDetail.setZipCode("5175");
		persDetail.setJob("development");
		persDetail.setIncome(24521.25);
		
		Person pers = new Person();
		pers.setName("cristina");
		pers.setpDetail(persDetail);
	
		session.save(pers);
		//no need if we set cascadeType
		//session.save(persDetail);
		session.getTransaction().commit();
	}

}
