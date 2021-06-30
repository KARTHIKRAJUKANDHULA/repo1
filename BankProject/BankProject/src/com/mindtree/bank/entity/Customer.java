package com.mindtree.bank.entity;

public class Customer {
private int customer_Id;
private String customerName;
private int customerAadhar;
public Customer() {
	super();
	// TODO Auto-generated constructor stub
}
public Customer(int customer_Id, String customerName, int customerAadhar) {
	super();
	this.customer_Id = customer_Id;
	this.customerName = customerName;
	this.customerAadhar = customerAadhar;
}
public int getCustomer_Id() {
	return customer_Id;
}
public void setCustomer_Id(int customer_Id) {
	this.customer_Id = customer_Id;
}
public String getCustomerName() {
	return customerName;
}
public void setCustomerName(String customerName) {
	this.customerName = customerName;
}
public int getCustomerAadhar() {
	return customerAadhar;
}
public void setCustomerAadhar(int customerAadhar) {
	this.customerAadhar = customerAadhar;
}
}
