package com.exemplu;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class DataInsertion {

	public static void main(String[] args) {
		// insert method
		// new DataInsertion().insertInfo();

		// select method
		// new DataInsertion().getInfo();

		// delete method
		//new DataInsertion().deleteInfo();
		
		//update method
		new DataInsertion().updateInfo1();
	}

	public void insertInfo() {
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");

		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();

		DataProvider provider = new DataProvider();
		provider.setUser_id(2);
		provider.setUser_name("ionut");
		provider.setUser_address("craiova");

		Transaction tr = session.beginTransaction();
		session.save(provider);
		tr.commit();

		System.out.println("Object saved successfully");

		session.close();
		sf.close();

	}

	public void getInfo() {
		DataProvider dp;
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");

		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();

		Object ob1 = session.load(DataProvider.class, new Integer(1));
		dp = (DataProvider) ob1;
		System.out.println("User " + dp.getUser_id() + " with name : " + dp.getUser_name() + " and address "
				+ dp.getUser_address());

	}

	public void deleteInfo() {
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");

		ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(con.getProperties()).build();
		SessionFactory sf = con.buildSessionFactory(sr);
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();

		Object ob1 = session.load(DataProvider.class, new Integer(1));
		session.delete(ob1);

		System.out.println("Object  remove successfully");

		tr.commit();
		session.close();
		sf.close();

	}

	public void updateInfo() {
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");

		ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(con.getProperties()).build();
		SessionFactory sf = con.buildSessionFactory(sr);
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Object ob1 = session.load(DataProvider.class, new Integer(2));

		DataProvider dp = (DataProvider) ob1;
		dp.setUser_address("severin");
		System.out.println("Object  update successfully");

		tr.commit();
		session.close();
		sf.close();
	}
	
	public void updateInfo1(){
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");

		ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(con.getProperties()).build();
		SessionFactory sf = con.buildSessionFactory(sr);
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		
		DataProvider dp = new DataProvider();
		dp.setUser_id(2);
		dp.setUser_name("stefan");
		dp.setUser_address("craiova");
		session.update(dp);
		System.out.println("Object  update successfully");

		tr.commit();
		session.close();
		sf.close();
	}

}
