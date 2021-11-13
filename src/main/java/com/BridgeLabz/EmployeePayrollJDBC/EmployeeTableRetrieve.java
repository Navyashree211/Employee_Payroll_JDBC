/*
 * UC5:- Ability to retrieve all employees who have joined in a particular data range from the payroll service database .
 * 
 * 
 * @author : Navaya Shree
 * @since : 12-11-2021
 */
package com.BridgeLabz.EmployeePayrollJDBC;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeTableRetrieve {
	static Connection con;

	public static void main(String[] args) throws Exception, SQLException {

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String qry = "select sum(basic_pay), avg(basic_pay), max(basic_pay), min(basic_pay) from employee_payroll.payroll_service where gender = 'F' and gender = 'M' group by gender ";
		try {
			Class.forName("com.mysql.jdbc.Driver");

			System.out.println("Driver Class Loaded");


			con = ConnectionDB.createCP();

			System.out.println("Connetion Establish with db server");

			pstmt = con.prepareStatement(qry);
			System.out.println("Data Update");

			rs = pstmt.executeQuery();
          
			while (rs.next()) {
				System.out.println(rs.getInt(1));
			}
			
//			while (rs.next()) {
//				int id = rs.getInt(1);
//				String name = rs.getString(2);
//				long phone_number = rs.getLong(3);
//				String address = rs.getString(4);
//               String department = rs.getString(5);
//				String gender = rs.getString(6);
//				double basic_pay = rs.getDouble(7);
//				double deductions = rs.getDouble(8);
//				double taxable_pay = rs.getDouble(9);
//				double tax = rs.getDouble(10);
//				double met_pay = rs.getDouble(11);
//				Date state = rs.getDate(12);
//
//				System.out.println("EmpId :-" + id + "  " +"EmpName :- " + name + " " + "Emp_PhoneNo. :-" + phone_number + " " + "EmpAddress :- " + address + " " + " EmpDepartment :-" + department + " "
//						+ "Gender :- "+ gender + " " + "Basic_Pay " +  basic_pay + " " + " Deduction :- " + deductions + " " + "Taxable_pay :- " + taxable_pay + " " + "Tax :-" +tax + " " + "Met_Pay :- " + met_pay
//						+ " " + "Date :-" +  state );
          
				//System.out.println(gender + " Gender having sum of Basic_Pay of Employee: " );
				
			//}

				
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
