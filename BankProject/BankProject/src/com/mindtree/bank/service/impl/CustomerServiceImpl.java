package com.mindtree.bank.service.impl;

import java.util.List;

import com.mindtree.bank.client.BankApp;
import com.mindtree.bank.dao.CustomerDao;
import com.mindtree.bank.dao.impl.CustomerDaoImpl;
import com.mindtree.bank.entity.Customer;
import com.mindtree.bank.exception.DaoException;
import com.mindtree.bank.exception.ServiceException;
import com.mindtree.bank.exception.service.IdNotFoundException;
import com.mindtree.bank.service.CustomerService;

public class CustomerServiceImpl implements CustomerService{
	CustomerDao dao=new CustomerDaoImpl();
	@Override
	public List<Customer> registerCustomer() throws ServiceException {
		// TODO Auto-generated method stub
		List<Customer> customerList =BankApp.createCustomerList();
		try {
			customerList=dao.registerCustomer(customerList);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage());
		}
	return customerList;
	}

	@Override
	public int unregisterCustomer(int customer_Id3) throws ServiceException {
		// TODO Auto-generated method stub
		int resultCount=0;
		try {
			resultCount=dao.unregisterCustomer(customer_Id3);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage());
		}
		if(resultCount==0) {
		try {
			throw new IdNotFoundException("Customer id not registered");
		}catch(IdNotFoundException e){
			System.out.println(e.getMessage());	
		}
		}
	return resultCount;
	}

}
