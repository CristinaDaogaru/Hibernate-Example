package com.exemplu.oneToOneMapping;

import javax.persistence.*;

@Entity
public class Person {

	private int id;
	private String name;

	private PersonDetail pDetail;
	
	
	@Id
	@GeneratedValue
	@Column(name = "detailId_PK")
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

	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="pDetail_FK")
	public PersonDetail getpDetail() {
		return pDetail;
	}

	public void setpDetail(PersonDetail pDetail) {
		this.pDetail = pDetail;
	}

}
