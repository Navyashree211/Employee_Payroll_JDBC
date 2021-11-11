/*
 * UC3:- Ability to update the salary i.e. the base pay for Employee Terisa to 3000000.00 and sync it with Database . 
 * 
 * @author : Navaya Shree
 * @since : 7-11-2021
 */
package com.BridgeLabz.EmployeePayrollJDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeTableUpdate {  
	public static void main(String[] args) throws SQLException {

		Connection con = null;
		Statement stmt = null;
		String qry = "update employee_payroll.payroll_service set basic_pay=3000000.00 where name='Terisa'";
		try {
			Class.forName("com.mysql.jdbc.Driver");

			System.out.println("Driver Class Loaded");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=1234");

			System.out.println("Connetion Establish with db server");

			stmt = con.createStatement();
			System.out.println("Platform Created");

			stmt.executeUpdate(qry);
			System.out.println("Data Update");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		finally {
			if (stmt != null) {
				try {
					stmt.close();
					System.out.println("Closed All Resources");
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
			if (con != null) {
				try {
					con.close();
					System.out.println("Closed All Resources");
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		}

	}
}
