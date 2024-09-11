package EmployeeManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class EmployeeData {
	//	EmployeeDao

	public static void createEmployee(Employee employee) throws Exception{
		Connection con=ConnectionPage.connect();
		String query=QueryPage.insert;
		PreparedStatement preparedStatement=con.prepareStatement(query);
		preparedStatement.setInt(1, employee.getId());
		preparedStatement.setString(2, employee.getName());
		preparedStatement.setString(3, employee.getEmail());
		preparedStatement.setInt(4, employee.getSalary());
		
		System.out.println(preparedStatement);
		preparedStatement.executeUpdate();
		preparedStatement.close();

	}
	
	public static void Update( String name,int id) throws Exception{
		
		Connection con=ConnectionPage.connect();
		String query=QueryPage.update;
		PreparedStatement preparedStatement=con.prepareStatement(query);
		preparedStatement.setString(1, name);
		preparedStatement.setInt(2, id);
		
		System.out.println(preparedStatement);
		preparedStatement.executeUpdate();
		preparedStatement.close();

	}
	
	//storing data into arraylist
	public static ArrayList<Employee> fetchEmployeeData() throws Exception{
		ArrayList<Employee> empList=new ArrayList<Employee>();
		Connection con=ConnectionPage.connect();
		String query=QueryPage.select;
		Statement statement=con.createStatement();
		System.out.println(statement);
		ResultSet rs=statement.executeQuery(query);
		
		while(rs.next()) {
			Employee emp=new Employee(rs.getInt(1),rs.getString(2), rs.getString(3),rs.getInt(4));
			empList.add(emp);
		}
		statement.close();
		return empList;
	}
	
	//delete data
	public static void deleteEmployee(int id) throws Exception{
		Connection con=ConnectionPage.connect();
		String query=QueryPage.delete;
		PreparedStatement preparedStatement=con.prepareStatement(query);
		preparedStatement.setInt(1, id);
		
		System.out.println(preparedStatement);
		preparedStatement.executeUpdate();
		preparedStatement.close();
	}

}
















