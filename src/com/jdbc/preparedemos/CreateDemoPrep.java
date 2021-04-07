package com.jdbc.preparedemos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDemoPrep {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sql = "create table coemployee(name varchar(20), empId integer primary key, city varchar(20))";
		//Scanner sc = new Scanner(System.in);
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "system";
		String password = "root";

		Connection connection = null;
		PreparedStatement ps = null;
		// establish a connection

		try {
			connection = DriverManager.getConnection(url, username, password);
			ps = connection.prepareStatement(sql);
			System.out.println("created " +( !ps.execute()) );
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	

}
