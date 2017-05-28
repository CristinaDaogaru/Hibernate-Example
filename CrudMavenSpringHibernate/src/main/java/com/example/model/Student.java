package com.example.model;

import javax.persistence.*;

@Entity
public class Student {
	private int studentId;
	private String firstName;
	private String lastName;
	private int yearLevel;

	public Student(int studentId, String firstName, String lastName, int yearLevel) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.yearLevel = yearLevel;
	}

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO) // for autonumber
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	@Column
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column
	public int getYearLevel() {
		return yearLevel;
	}

	public void setYearLevel(int yearLevel) {
		this.yearLevel = yearLevel;
	}

	public Student() {

	}

}
