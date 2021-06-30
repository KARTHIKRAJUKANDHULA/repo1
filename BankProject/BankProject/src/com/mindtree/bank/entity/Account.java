package com.mindtree.bank.entity;

public class Account {
private int account_Id;
private String branchName;
private double balance;
private int customer_Id;
public Account() {
	super();
}
public Account(int account_Id, String branchName, double balance, int customer_Id) {
	super();
	this.account_Id = account_Id;
	this.branchName = branchName;
	this.balance = balance;
	this.customer_Id = customer_Id;
}
public int getAccount_Id() {
	return account_Id;
}
public void setAccount_Id(int account_Id) {
	this.account_Id = account_Id;
}
public String getBranchName() {
	return branchName;
}
public void setBranchName(String branchName) {
	this.branchName = branchName;
}
public double getBalance() {
	return balance;
}
public void setBalance(double balance) {
	this.balance = balance;
}
public int getCustomer_Id() {
	return customer_Id;
}
public void setCustomer_Id(int customer_Id) {
	this.customer_Id = customer_Id;
}
}
