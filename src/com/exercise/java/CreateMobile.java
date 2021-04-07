package com.exercise.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateMobile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String sql = "create table mobile( Id integer primary key,brand varchar(20), model varchar(20),price integer)";
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


