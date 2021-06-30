package com.mindtree.bank.service.impl;

import java.util.List;

import com.mindtree.bank.client.BankApp;
import com.mindtree.bank.dao.AccountDao;
import com.mindtree.bank.dao.impl.AccountDaoImpl;
import com.mindtree.bank.entity.Account;
import com.mindtree.bank.exception.DaoException;
import com.mindtree.bank.exception.ServiceException;
import com.mindtree.bank.exception.service.IdNotFoundException;
import com.mindtree.bank.service.AccountService;

public class AccountServiceImpl implements  AccountService {
	AccountDao dao=new AccountDaoImpl();
	@Override
	public List<Account> createAccount() throws ServiceException {
		// TODO Auto-generated method stub
		List<Account> accountList = BankApp.createAccountList();
		try {
			  accountList=dao.createAccount(accountList);
			} catch (DaoException e) {
			  throw new ServiceException("problem with sql query");
			}
		if(accountList.isEmpty()) {
			try {
			    throw new IdNotFoundException("customer not registered");
			    }catch(IdNotFoundException e){
			     System.out.println(e.getMessage());	
			}
		}	
	return accountList;
	}

	@Override
	public double updateAccountBalance(int customer_Id, double balance) throws ServiceException {
		// TODO Auto-generated method stub
		Double Updatedbalance;
		try {
			  Updatedbalance=dao.updateAccountBalance(customer_Id,balance);
			} catch (DaoException e) {
			  throw new ServiceException("problem with sql query");
			}
		if(Updatedbalance==0.0){
		try {
			  throw new IdNotFoundException("account id not found");
			} catch(IdNotFoundException e){
			  System.out.println(e.getMessage());	
			}}
	return Updatedbalance;
	}


	@Override
	public int deactivateAccount(int account_Id1) throws ServiceException {
		// TODO Auto-generated method stub
		int resultCount=0;
		try {
			  resultCount=dao.deactivateAccount(account_Id1);
			} catch (DaoException e) {
			  throw new ServiceException("problem with sql query");
			}
		if(resultCount==0) {
		    try {
			   throw new IdNotFoundException("Account id not registered");
			}  catch(IdNotFoundException e){
			   System.out.println(e.getMessage());	
			}
		}
	return resultCount;
	}

}
