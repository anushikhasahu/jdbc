package com.jdbc.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String sql = "select * from costudent";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "system";
		String password = "root";

		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;

		try {
			connection = DriverManager.getConnection(url, username, password);
			statement = connection.createStatement();
			// execute the statement and pass the query
			 rs = statement.executeQuery(sql);
			while(rs.next()) {
				String name = rs.getString("name");
				int id = rs.getInt(2);
				String city = rs.getString("city");
				System.out.println(name+"\t"+id+"\t"+city);
			}
		//	System.out.println("table created " + result);
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


