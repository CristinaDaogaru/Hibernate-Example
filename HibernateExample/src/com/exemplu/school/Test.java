package com.exemplu.school;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;



public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AnnotationConfiguration configuration = new AnnotationConfiguration();
		configuration.addAnnotatedClass(School.class);
		configuration.configure();
		
		new SchemaExport(configuration).create(true, true);
		
		SessionFactory factory  = configuration.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		session.beginTransaction();
		
		SchoolDetail det = new SchoolDetail();
		det.setPublicSchool(false);
		det.setAdress("craiova");
		det.setStudentCount(200);
		
		School sch =new School();
		sch.setName("ace");
		sch.setSchoolDetail(det);
		
		session.save(sch);
		session.getTransaction().commit();
	}

}
