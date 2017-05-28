package com.exemplu.oneToOneMapping;

import javax.persistence.*;

@Entity
public class PersonDetail {

	private int persDetailId;
	private String zipCode;
	private String job;
	private double income;

	private Person person;
	
	@Id
	public int getPersDetailId() {
		return persDetailId;
	}

	public void setPersDetailId(int persDetailId) {
		this.persDetailId = persDetailId;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public double getIncome() {
		return income;
	}

	public void setIncome(double income) {
		this.income = income;
	}

	@OneToOne(mappedBy = "pDetail",cascade = CascadeType.ALL)
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
