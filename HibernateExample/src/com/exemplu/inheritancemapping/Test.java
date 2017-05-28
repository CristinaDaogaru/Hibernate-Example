package com.exemplu.inheritancemapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;



public class Test {

	public static void main(String[] args) {
		AnnotationConfiguration configuration = new AnnotationConfiguration();
		configuration.addAnnotatedClass(Project.class);
		configuration.addAnnotatedClass(Module.class);
		configuration.addAnnotatedClass(Task.class);
		configuration.configure();
		
		new SchemaExport(configuration).create(true, true);
		
		SessionFactory factory  = configuration.buildSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		Project p = new Project();
		p.setProjectName("hibernate");
		
		Module m = new Module();
		m.setProjectName("spring");
		m.setModuleName("aop");
		
		Task t =new Task();
		t.setProjectName("java");
		t.setModuleName("colection");
		t.setTaskName("array");
		
		session.save(p);
		session.save(m);
		session.save(t);

		session.getTransaction().commit();
		
	}

}
