package com.example.employee;


import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "EmployeeInfo")
public class Employee {

	private int id;
	private String name;
	private String password;
	private String email;
	private boolean isPermanent;
	private Calendar joinDate;
	private Date loginTime;

	@Id
	@TableGenerator(name = "id",table = "emppkb",pkColumnName="empkey"
		,pkColumnValue="empvalue",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE,generator = "id")
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

	@Transient // don't save this column in the table
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Basic
	public boolean isPermanent() {
		return isPermanent;
	}

	public void setPermanent(boolean isPermanent) {
		this.isPermanent = isPermanent;
	}
	@Temporal(TemporalType.DATE)
	public Calendar getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Calendar joinDate) {
		this.joinDate = joinDate;
	}
	@Temporal(TemporalType.TIMESTAMP)
	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

}
