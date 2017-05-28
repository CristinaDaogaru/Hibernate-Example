package com.example.customer;

import javax.persistence.*;

@Entity
@Table(name="Customer")
@SecondaryTable(name="CustomerDetail")
public class Customer {

	private int id;
	private String name;
	private String address;
	private int credtScore;
	private int rewardPoints;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(table="CustomerDetail")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	@Column(table="CustomerDetail")
	public int getCredtScore() {
		return credtScore;
	}

	public void setCredtScore(int credtScore) {
		this.credtScore = credtScore;
	}
	@Column(table="CustomerDetail")
	public int getRewardPoints() {
		return rewardPoints;
	}

	public void setRewardPoints(int rewardPoints) {
		this.rewardPoints = rewardPoints;
	}

}
