package com.BridgeLabz.EmployeePayrollJDBC;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {    
	static Connection con;
	public static Connection createCP() throws Exception   {   
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=1234");
		
		return con;
		
	}
}
