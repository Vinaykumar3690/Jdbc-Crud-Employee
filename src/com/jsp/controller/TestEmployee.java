package com.jsp.controller;

import java.sql.SQLException;

import java.util.List;

import com.jsp.dao.EmployeeDao;
import com.jsp.dto.Employee;

public class TestEmployee {
	public static void main(String[] args) throws SQLException {
		EmployeeDao employeeDao = new EmployeeDao();
		// employeeDao.createtableEmployee();

		Employee emp1 = new Employee();
		emp1.setId(7);
		emp1.setName("singh");
		emp1.setSal(143.00);
		emp1.setEmail("singh@123");
		emp1.setPassword("sin@1234");
		emp1.setPhone(231431433);

		employeeDao.saveEmployee(emp1);
		if (emp1 != null) {
			System.out.println("data saved");
		} else {

			System.out.println("data not saved");
		}
/*      	  
		int res= employeeDao.deleteEmployee(emp1);
		
		if(res>0) {
			System.out.println("data deleted");
		}
		else {
			System.out.println("data not deleted");
		}
		
		 
		  
		  */
		
	}
}
