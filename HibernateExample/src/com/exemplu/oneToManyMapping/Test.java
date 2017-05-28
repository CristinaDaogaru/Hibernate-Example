package com.exemplu.oneToManyMapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;


public class Test {

	public static void main(String[] args) {
		AnnotationConfiguration configuration = new AnnotationConfiguration();
		configuration.addAnnotatedClass(Student.class);
		configuration.addAnnotatedClass(College.class);
		configuration.configure();
		
		new SchemaExport(configuration).create(true, true);
		
		SessionFactory factory  = configuration.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		session.beginTransaction();
		
		College college = new College();
		college.setColegeName("ace");
		
		Student student = new Student();
		student.setStudentName("cristina");
		
		Student student2 = new Student();
		student2.setStudentName("ionut");
		
		student.setCollege(college);
		student2.setCollege(college);
		
		session.save(student);
		session.save(student2);
		session.save(college);
		session.getTransaction().commit();
		
	}

}
