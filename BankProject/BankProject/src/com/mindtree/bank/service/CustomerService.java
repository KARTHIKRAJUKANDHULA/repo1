package com.mindtree.bank.service;

import java.util.List;

import com.mindtree.bank.entity.Customer;
import com.mindtree.bank.exception.ServiceException;

public interface CustomerService {

	List<Customer> registerCustomer() throws ServiceException;

	int unregisterCustomer(int customer_Id3) throws ServiceException;

}
