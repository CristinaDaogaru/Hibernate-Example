package com.exemplu.compoundkey;

import java.io.Serializable;

import javax.persistence.*;


@Embeddable
public class CompoundKey implements Serializable {

	private int userIs;
	private int accountId;

	
	
	public CompoundKey(int userIs, int accountId) {
		
		this.userIs = userIs;
		this.accountId = accountId;
	}

	public int getUserIs() {
		return userIs;
	}

	public void setUserIs(int userIs) {
		this.userIs = userIs;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
}
