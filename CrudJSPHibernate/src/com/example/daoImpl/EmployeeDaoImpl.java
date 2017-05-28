package com.example.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.dao.DaoInterface;
import com.example.pojo.EmployeeDetails;

public class EmployeeDaoImpl implements DaoInterface {

	@Override
	public void saveEmployee(EmployeeDetails employee) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		session.save(employee);
		transaction.commit();
		
		session.close();
	}

	@Override
	public List<EmployeeDetails> showAllEmployees() {
		
		List<EmployeeDetails> employeeDetails = new ArrayList<>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Query query = session.createQuery("from EmployeeDetails");
		employeeDetails = query.list();

		return employeeDetails;
	}

	@Override
	public void updateEmployee(int id, String ename, String enumber) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		EmployeeDetails employeeDetails = (EmployeeDetails) session.load(EmployeeDetails.class, id);
		employeeDetails.setEname(ename);
		employeeDetails.setEnumber(enumber);
		
		session.update(employeeDetails);
		transaction.commit();
		
		session.close();
		
	}

	@Override
	public void deleteEmployee(EmployeeDetails employee) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		session.delete(employee);
		transaction.commit();
		session.close();
		
	}

}
