/*
 * UC2:- Ability for Employee_Payroll_Service to retrieve the EmployeePayroll from the database. 
 * 
 * @author : Navaya Shree
 * @since : 7-11-2021
 */
package com.BridgeLabz.EmployeePayrollJDBC;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.sql.Connection;

public class DBDemo2 {
	public static void main(String[] args) throws SQLException {

		String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service?useSSL=false";
		String userName = "root";
		String password = "1234";
		Statement stmt = null;
		Connection con = null;
		ResultSet rs = null;

		String qry = "select * from employee_payroll.payroll_service";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Class Loaded");

			con = DriverManager.getConnection(jdbcURL, userName, password);
			System.out.println("Connetion Establish with db server");

			stmt = con.createStatement();

			rs = stmt.executeQuery(qry);

			System.err.println("id-> " + "EmployeesName-> " + "mobileNumber-> " + "address-> " + "       department-> "
					+ "gender-> " + " basic_pay-> " + "deductions-> " + "taxable_pay-> " + "tax-> " + "met_pay-> "
					+ "start");

			while (rs.next()) {
				int id = rs.getInt("Id");
				String EmployeesName = rs.getString(2);
				long mobileNumber = rs.getLong(3);
				String address = rs.getString(4);
				String department = rs.getString(5);
				String gender = rs.getString(6);
				double basic_pay = rs.getDouble(7);
				double deductions = rs.getDouble(8);
				double taxable_pay = rs.getDouble(9);
				double tax = rs.getDouble(10);
				double met_pay = rs.getDouble(11);
				Date start = rs.getDate(12);

				System.out.println();

				System.out.println(id + "->" + EmployeesName + "->" + mobileNumber + "->" + address + "->" + department
						+ "->" + gender + "->" + basic_pay + "->" + deductions + "->" + taxable_pay + "->" + tax + "->"
						+ met_pay + "->" + start);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
			if (stmt != null) {
				try {
					stmt.close();

				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		}

	}
}
