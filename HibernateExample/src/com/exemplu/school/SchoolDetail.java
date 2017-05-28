package com.exemplu.school;

import javax.persistence.Embeddable;

@Embeddable
public class SchoolDetail {

	private String adress;
	private boolean isPublicSchool;
	private int studentCount;

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public boolean isPublicSchool() {
		return isPublicSchool;
	}

	public void setPublicSchool(boolean isPublicSchool) {
		this.isPublicSchool = isPublicSchool;
	}

	public int getStudentCount() {
		return studentCount;
	}

	public void setStudentCount(int studentCount) {
		this.studentCount = studentCount;
	}

}
