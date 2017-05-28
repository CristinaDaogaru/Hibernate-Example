package com.application.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.application.hibernate.util.HibernateUtil;
import com.application.model.User;

public class RegisterService {

	public boolean register(User user){
		Session session = HibernateUtil.openSession();
		
		if(isUserExists(user))
			return false;
		Transaction tx = null;
		try{
			tx = session.getTransaction();
			tx.begin();
			session.saveOrUpdate(user);
			tx.commit();
			
		}catch (Exception e) {
			if(tx != null)
			{
				tx.rollback();
			}
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return true;
	}
	
	
	

	private boolean isUserExists(User user) {
		Session session = HibernateUtil.openSession();
		boolean result = false;
		Transaction tx = null;
		try{
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from User where userId='" + user.getUserId() + "'");
			User u = (User) query.uniqueResult();
			tx.commit();
			if(u != null)
				result = true;
			
		}catch (Exception e) {
			if(tx != null){
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return result;
	
		
	
	}
}
