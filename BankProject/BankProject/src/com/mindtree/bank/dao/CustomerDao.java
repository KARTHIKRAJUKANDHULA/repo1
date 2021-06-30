package com.mindtree.bank.dao;

import java.util.List;

import com.mindtree.bank.entity.Customer;
import com.mindtree.bank.exception.DaoException;

public interface CustomerDao {

	List<Customer> registerCustomer(List<Customer> customerList) throws DaoException;
	int unregisterCustomer(int customer_Id3) throws DaoException;

}
