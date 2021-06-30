package com.mindtree.bank.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.mindtree.bank.dao.AccountDao;
import com.mindtree.bank.entity.Account;
import com.mindtree.bank.exception.DaoException;
import com.mindtree.bank.utility.DbConnector;

public class AccountDaoImpl implements AccountDao  {

	@Override
	public List<Account> createAccount(List<Account> accountList) throws DaoException {
		// TODO Auto-generated method stub
		Connection connection = DbConnector.connectionToDatabase();
		PreparedStatement statement = null;
		ResultSet resultSet=null;
		List<Account> accountList2 = new ArrayList<Account>();
		for(int i=0;i<accountList.size();i++)
		{
			int account_id=accountList.get(i).getAccount_Id();
			String branchName=accountList.get(i).getBranchName();
			double balance=accountList.get(i).getBalance();
			int customer_id=accountList.get(i).getCustomer_Id();
			
		if (!Objects.isNull(connection)) {
			try {
				String sqlQuery = "select* from customer where customer_id="+customer_id;
				statement = connection.prepareStatement(sqlQuery);
				resultSet = statement.executeQuery();
				if(resultSet.next()) {
					String sqlQuery2 = "insert into account values(?,?,?,?)";				
					statement = connection.prepareStatement(sqlQuery2);
					statement.setInt(1,account_id);
					statement.setString(2,branchName);
					statement.setDouble(3,balance);
					statement.setInt(4,customer_id);
					statement.executeUpdate();
					String sqlQuery3 = "select* from account where account_Id="+account_id;
					statement = connection.prepareStatement(sqlQuery3);
					resultSet=statement.executeQuery();
					while (resultSet.next()) {
						Account account = new Account();
						account.setAccount_Id(resultSet.getInt("account_Id"));
						account.setBranchName(resultSet.getString(2));
						account.setBalance(resultSet.getInt("balance"));
						account.setCustomer_Id(resultSet.getInt("customer_Id"));
						accountList2.add(account);
					}
				}
			
			} catch (SQLException e) {
				throw new DaoException("problem with sql query2");
			}
			}
		}
		DbConnector.resultSetClose(resultSet);
	    DbConnector.statementClose(statement);
	    DbConnector.connectionClose(connection);
		return accountList2;
	}

	@Override
	public int deactivateAccount(int account_Id) throws DaoException {
		// TODO Auto-generated method stub
		Connection connection = DbConnector.connectionToDatabase();
		PreparedStatement statement = null;
		int count=0;
		if (!Objects.isNull(connection)) {
		try {
				String sqlQuery="delete from account where account_Id="+account_Id;
				statement = connection.prepareStatement(sqlQuery);
				count=statement.executeUpdate();	
			 }  catch (SQLException e) {
				throw new DaoException("problem with sql query2");
			}
			}
	    DbConnector.statementClose(statement);
	    DbConnector.connectionClose(connection);
		    return count;
	}

	@Override
	public double updateAccountBalance(int account_Id, double balance) throws DaoException {
		// TODO Auto-generated method stub
		Connection connection = DbConnector.connectionToDatabase();
		PreparedStatement statement = null;
		ResultSet resultSet=null;
		Double Updatedbalance=0.0;
		try {
			String sqlQuery = "update joins.account set balance= ? where account.account_Id=" + account_Id;
			PreparedStatement pstmt = connection.prepareStatement(sqlQuery);
			pstmt.setDouble(1,balance);
			pstmt.executeUpdate();
			String sqlQuery3 = "select balance from joins.account where account_Id="+account_Id;
			statement = connection.prepareStatement(sqlQuery3);
			resultSet=statement.executeQuery();
			while(resultSet.next()) {
			Updatedbalance=resultSet.getDouble("balance");
			}
			} catch (SQLException e) {
				throw new DaoException("problem with sql query");
		    }
			DbConnector.resultSetClose(resultSet);
		   DbConnector.statementClose(statement);
			return Updatedbalance;
	}

}
