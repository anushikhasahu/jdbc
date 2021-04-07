package com.jdbc.java;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



public class CreateDemo {

	public static void main(String[] args) {
		String sql = "create table costudent(name varchar(20), studId integer primary key, city varchar(20))";
		//Scanner sc = new Scanner(System.in);
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "system";
		String password = "root";

		Connection connection = null;
		Statement statement = null;
		// establish a connection

		try {
			connection = DriverManager.getConnection(url, username, password);
			// create a statement object
			statement = connection.createStatement();
			// execute the statement and pass the query
			boolean result = statement.execute(sql);
			System.out.println("table created " + result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null)
					statement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
