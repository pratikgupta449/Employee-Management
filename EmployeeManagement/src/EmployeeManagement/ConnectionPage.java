package EmployeeManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPage {
	//DB
	static Connection con=null;
	
	public static Connection connect() {
		
		try {
			String Driver="com.mysql.cj.jdbc.Driver";
			String url="jdbc:mysql://localhost:3306/";
			String db="db2";
			String user="root";
			String pwd="root";
			
			Class.forName(Driver);
			
			con=DriverManager.getConnection(url+db,user,pwd);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return con;
		
	}

}
