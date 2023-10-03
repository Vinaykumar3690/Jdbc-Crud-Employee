package com.jsp.dao;


import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.jsp.dto.Employee;
import com.mysql.cj.jdbc.Driver;


public class EmployeeDao {
	public void createtableEmployee() throws SQLException {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc-crud1","root","root 12");
			Statement statement = connection.createStatement();

			statement.execute(
					"create table employee(Id int Primary Key,name varchar(45),phone bigint,sal double,email varchar(40),password varchar(20))");
			connection.close();

			System.out.println("table created");

			
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
	}

	public int saveEmployee(Employee employee) {
	
		
		try {
			
			DriverManager.registerDriver(new Driver());
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc-crud","root","root 12");
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into Employee values(?,?,?,?,?,?)");

			preparedStatement.setInt(1, employee.getId());
			preparedStatement.setString(2, employee.getName());
			preparedStatement.setLong(3, employee.getPhone());
			preparedStatement.setDouble(4, employee.getSal());
			preparedStatement.setString(5, employee.getEmail());
			preparedStatement.setString(6, employee.getPassword());

			int res = preparedStatement.executeUpdate();

			connection.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return 0;

	}

	public int updateEmployee(Employee employee) {
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc-crud", "root",
					"root 12");
			PreparedStatement preparedStatement = connection.prepareStatement(
					"update employee set Name=?,setPhone=?,setSal=?,setEmail=?,setPassword=? where id=?");

			preparedStatement.setString(1, employee.getName());
			preparedStatement.setLong(2, employee.getPhone());
			preparedStatement.setDouble(3, employee.getSal());
			preparedStatement.setString(4, employee.getEmail());
			preparedStatement.setString(5, employee.getPassword());
			preparedStatement.setInt(6, employee.getId());

			int res = preparedStatement.executeUpdate();

			connection.close();
			return res;
			
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {

			e.printStackTrace();
			
		}
		return 0;
	}

	public int deleteEmployee(Employee employee) throws SQLException   {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc-crud","root","root 12");
			PreparedStatement preparedStatement=connection.prepareStatement("delete from employee where id=?");
			
			preparedStatement.setString(1, employee.getName());
			preparedStatement.setLong(2, employee.getPhone());
			preparedStatement.setDouble(3, employee.getSal());
			preparedStatement.setString(4, employee.getEmail());
			preparedStatement.setString(5, employee.getPassword());
			preparedStatement.setInt(6, employee.getId());
      
			 int res=preparedStatement.executeUpdate();
			 connection.close();
			 return res;
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return 0;
		
	}
	


	public List<Employee> getAllEmployee() throws SQLException {
		List<Employee> list = new ArrayList<Employee>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc-crud","root","root 12");
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from employee");

			while (resultSet.next()) {

				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				long phone = resultSet.getLong(3);
				double sal = resultSet.getDouble(4);
				String email = resultSet.getString(5);
				String password = resultSet.getString(6);

				Employee employee = new Employee();

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}
	
	
	public Employee getEmployeeById(int id) throws SQLException {

		Employee employee = new Employee();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("dbc:mysql://localhost:3306/jdbc-crud","root","root 12");
			PreparedStatement preStatement = connection.prepareStatement("select * from employee where id=?");

			preStatement.setInt(1, id);

			ResultSet resultSet = preStatement.executeQuery();
			while (resultSet.next()) {

				int id1 = resultSet.getInt(1);
				String name = resultSet.getString(2);
				long phone = resultSet.getLong(3);
				double sal = resultSet.getDouble(4);
				String email = resultSet.getString(5);
				String password = resultSet.getString(6);

				employee.setId(id);
				employee.setName(name);
				employee.setPhone(phone);
				employee.setSal(sal);
				employee.setEmail(email);
				employee.setPassword(password);

			}
			
			connection.close();

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

		return employee;

	}

	
	
}

