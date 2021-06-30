package com.mindtree.bank.service;

import java.util.List;

import com.mindtree.bank.entity.Account;
import com.mindtree.bank.exception.ServiceException;

public interface AccountService {

	List<Account> createAccount() throws ServiceException;

	double updateAccountBalance(int account_Id, double balance) throws ServiceException;

	int deactivateAccount(int account_Id1) throws ServiceException;

}
