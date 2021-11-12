/*
 * UC4:- Ability to update the salary i.e. the base pay for 
 *       Employee Terisa to 3000000 Database using JDBC PreparedStatement. 
 * 
 * @author : Navaya Shree
 * @since : 12-11-2021
 */
package com.BridgeLabz.EmployeePayrollJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeTableUpdate {
	static Connection con;

	public static void main(String[] args) throws Exception , SQLException {   
		
	
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String qry = "update employee_payroll.payroll_service set basic_pay=3000000.00 where name='Terisa'";
		try {
			Class.forName("com.mysql.jdbc.Driver");

			System.out.println("Driver Class Loaded");

			con = ConnectionDB.createCP();

			System.out.println("Connetion Establish with db server");

			pstmt = con.prepareStatement(qry);
			System.out.println("Data Update");
			
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
			if (pstmt != null) {
				try {
					pstmt.close();

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
			System.out.println("Closed All Resources");
		}

	}
}

