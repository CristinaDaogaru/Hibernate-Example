package com.exemplu.oneToManyMapping;

import java.util.*;

import javax.persistence.*;

@Entity
public class College {

	
	private int collegeId;
	private String colegeName;
	private List<Student> students;

	@Id
	@GeneratedValue
	public int getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}

	public String getColegeName() {
		return colegeName;
	}

	public void setColegeName(String colegeName) {
		this.colegeName = colegeName;
	}

	@OneToMany(targetEntity =Student.class,mappedBy="college" ,cascade = CascadeType.ALL,fetch = FetchType.LAZY )
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

}
