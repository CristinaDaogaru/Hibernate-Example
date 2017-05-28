package com.example.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.dao.StudentDao;
import com.example.model.Student;

public class StudentDaoImpl implements StudentDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void add(Student student) {

		sessionFactory.getCurrentSession().save(student);
	}

	@Override
	public void edit(Student student) {
		sessionFactory.getCurrentSession().update(student);
		
	}

	@Override
	public void delete(int studentId) {
	
		sessionFactory.getCurrentSession().delete(getStudent(studentId));

	}

	@Override
	public Student getStudent(int studentId) {
		return (Student) sessionFactory.getCurrentSession().get(Student.class, studentId);
	}

	@Override
	public List getAllStudent() {
		return sessionFactory.getCurrentSession().createQuery("from Student").list();
	}

}
