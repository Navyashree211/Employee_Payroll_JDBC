/*
 * UC1:- TO Create a payroll service database and have java program connect to database. 
 * 
 * @author : Navaya Shree
 * @since : 7-11-2021
 */
package com.BridgeLabz.EmployeePayrollJDBC;

import java.sql.DriverManager;
import java.util.Enumeration;
import java.sql.Connection;
import java.sql.Driver;

public class DBDemo {

	public static void main(String[] args) {

		String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service?useSSL=false";
		String userName = "root";
		String password = "1234";
		Connection con;
		try {

			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded");

		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("Cannot find the driver in the classpath!", e);
		}
		listDrivers();

		try {

			System.out.println("Connecting to database" + jdbcURL);
			con = DriverManager.getConnection(jdbcURL, userName, password);
			System.out.println("Connection is successfull!!!!" + con);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void listDrivers() {
		Enumeration<Driver> driverList = DriverManager.getDrivers();
		while (driverList.hasMoreElements()) {
			Driver driverClass = (Driver) driverList.nextElement();
			System.out.println("listDriver " + driverClass.getClass().getName());
		}
	}
}
