package com.mindtree.bank.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mindtree.bank.entity.Account;
import com.mindtree.bank.entity.Customer;
import com.mindtree.bank.exception.ApplicationException;
import com.mindtree.bank.exception.ServiceException;
import com.mindtree.bank.service.AccountService;
import com.mindtree.bank.service.CustomerService;
import com.mindtree.bank.service.impl.AccountServiceImpl;
import com.mindtree.bank.service.impl.CustomerServiceImpl;

public class BankApp {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args)  {
		CustomerService customerService = new CustomerServiceImpl();
		AccountService accountService = new AccountServiceImpl();
		byte choice;
		do {
			System.out.println("1.register the customer");
			System.out.println("2.create an account for the registered customer");
			System.out.println("3.update account balance of a customer");
			System.out.println("4.deactivate a particular account of customer");
			System.out.println("5.unregister a customer");
			System.out.println("6.exit");
			System.out.println("enter your choice");
			choice = sc.nextByte();
			switch (choice) {
			case 1:
				List<Customer> customerList;
				try {
					customerList = customerService.registerCustomer();
					if (!customerList.isEmpty()) {
						System.out.println("Customer registered successfully");
						customerDisplay(customerList);
					}
				} catch (ServiceException e1) {
					System.out.println(e1.getMessage());;
				}
				
				break;
			case 2:
				List<Account> accountList2;
				try {
					accountList2 = accountService.createAccount();
					if (!accountList2.isEmpty())
						accountDisplay(accountList2);
				} catch (ServiceException e) {
					System.out.println(e.getMessage());
				}
				
				break;
			case 3:
				System.out.println("Enter account id:");
				int account_Id = sc.nextInt();
				System.out.println("Enter balance to update:");
				double balance = sc.nextDouble();
				double Updatedbalance;
				try {
					Updatedbalance = accountService.updateAccountBalance(account_Id, balance);
					if (Updatedbalance != 0.0)
						System.out.println("Balance is updated to:" + Updatedbalance);
				} catch (ServiceException e) {
					System.out.println(e.getMessage());
				}
				
				break;
			case 4:
				System.out.println("Enter account id:");
				int account_Id1 = sc.nextInt();
				try {
					int result1 = accountService.deactivateAccount(account_Id1);
				} catch (ServiceException e) {
					System.out.println(e.getMessage());
				}
				System.out.println("Account deactivated with the id:" + account_Id1);
				break;
			case 5:
				System.out.println("Enter customer id:");
				int customer_Id3 = sc.nextInt();
				try {
					int result2 = customerService.unregisterCustomer(customer_Id3);
				} catch (ServiceException e) {
					System.out.println(e.getMessage());
				}
				System.out.println("unregistered customer with the id:" + customer_Id3);
				break;
			case 6:
				System.out.println("you are exited");
				break;
			default:
				System.out.println("Invalid choice");
			}
		} while (choice != 6);
	}

	public static List<Customer> createCustomerList() {
		System.out.println("enter number of Customers you want to add");
		int numberOfCustomers = sc.nextInt();
		List<Customer> customerList = new ArrayList<Customer>();
		for (int i = 0; i < numberOfCustomers; i++) {
			Customer customer = new Customer();
			System.out.println("enter customer id");
			int customer_Id = sc.nextInt();
			System.out.println("enter customer name");
			sc.nextLine();
			String CustomerName = sc.nextLine();
			System.out.println("Enter customer Adhar");
			int CustomerAdhar = sc.nextInt();
			customer = new Customer(customer_Id, CustomerName, CustomerAdhar);
			customerList.add(customer);
		}
		return customerList;
	}

	public static List<Account> createAccountList() {
		System.out.println("enter number of Account you want to add");
		int noOfAccounts = sc.nextInt();
		List<Account> accountList = new ArrayList<Account>();
		for (int j = 0; j < noOfAccounts; j++) {
			Account account = new Account();
			System.out.println("Enter the Account  id");
			int account_Id = sc.nextInt();
			System.out.println("Enter the branch name");
			sc.nextLine();
			String branchName = sc.nextLine();
			System.out.println("Enter balance");
			double balance = sc.nextDouble();
			System.out.println("enter customer id");
			int customer_Id = sc.nextInt();
			account = new Account(account_Id, branchName, balance, customer_Id);
			accountList.add(account);
		}
		return accountList;
	}

	public static void customerDisplay(List<Customer> customerList) {
		for (int i = 0; i < customerList.size(); i++) {
			System.out.println("customer_ID:" + customerList.get(i).getCustomer_Id() + "\n" + "customer Name:"
					+ customerList.get(i).getCustomerName() + "\n" + "customer Adhar:"
					+ customerList.get(i).getCustomerAadhar());
		}
	}

	public static void accountDisplay(List<Account> accountList) {
		for (int i = 0; i < accountList.size(); i++) {
			System.out.println("Account_Id:" + accountList.get(i).getAccount_Id() + "\n" + "BranchName:"
					+ accountList.get(i).getBranchName() + "\n" + "Balance:" + accountList.get(i).getBalance() + "\n"
					+ "Customer_Id:" + accountList.get(i).getCustomer_Id() + "\n");
		}
	}
}
