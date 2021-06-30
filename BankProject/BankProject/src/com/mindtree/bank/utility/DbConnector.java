package com.mindtree.bank.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mindtree.bank.exception.UtilityException;

public class DbConnector{
	static Connection connection=null;
	static String url="jdbc:mysql://localhost:3306/neondb";
	static String userName="root";
	static String password="kbps408419";
	public static Connection connectionToDatabase() throws UtilityException  
	{
		Connection connection=null;
				try{
					Class.forName("com.mysql.jdbc.Driver");
			        connection=DriverManager.getConnection(url,userName,password);
				   }
				catch(ClassNotFoundException | SQLException e)
				{
						throw new UtilityException("conncetion not found");
				}
		return connection;
		}
	public static void connectionClose(Connection connection) {
		if (connection != null) 
		try { 
				connection.close(); 
			} catch (SQLException ignore) {}
	}
	
	public static void statementClose(PreparedStatement statement) {
		if (statement != null)
		try {
			statement.close(); 
		} catch (SQLException ignore) {}
		}
	
	
	public static void resultSetClose(ResultSet resultSet) {
		if (resultSet != null) 
		try { 
				resultSet.close(); 
				} catch (SQLException ignore) {}
	}
}
