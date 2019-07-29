package com.scb.gauss.model;

public class Accounts {
	
  private int accountnumber;
 private String currency;
  private int balance;
  private int customerId;
  private int groupId;

public Accounts(int accountnumber, String currency, int balance, int customerId, int groupId) {
	super();
	this.accountnumber = accountnumber;
	this.currency = currency;
	this.balance = balance;
	this.customerId = customerId;
	this.groupId = groupId;
}
public int getAccountnumber() {
	return accountnumber;
}
public void setAccountnumber(int accountnumber) {
	this.accountnumber = accountnumber;
}
public String getCurrency() {
	return currency;
}
public void setCurrency(String currency) {
	this.currency = currency;
}
public int getBalance() {
	return balance;
}
public void setBalance(int balance) {
	this.balance = balance;
}
public int getCustomerId() {
	return customerId;
}
public void setCustomerId(int customerId) {
	this.customerId = customerId;
}
public int getGroupId() {
	return groupId;
}
public void setGroupId(int groupId) {
	this.groupId = groupId;
}
public Accounts() {
		super();
	}
@Override
public String toString() {
	return "Accounts [accountnumber=" + accountnumber + ", Currency=" + currency + ", Balance=" + balance
			+ ", CustomerId=" + customerId + ", GroupId=" + groupId + "]";
}
}