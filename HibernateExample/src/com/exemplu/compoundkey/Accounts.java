package com.exemplu.compoundkey;

import javax.persistence.*;

@Entity
public class Accounts {


	private CompoundKey compoundKey;
	private int accountBalance;

	@Id
	public CompoundKey getCompoundKey() {
		return compoundKey;
	}

	public void setCompoundKey(CompoundKey compoundKey) {
		this.compoundKey = compoundKey;
	}

	public int getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}

}
