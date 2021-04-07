package com.jdbc.preparedemos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultScroolDemo {

	public static void main(String[] args) {
		
        String sql = "select * from coemployee";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "system";
		String password = "root";

		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;

		try {
			connection = DriverManager.getConnection(url, username, password);
			statement = connection.createStatement(
				ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY	
					);
			
			 rs = statement.executeQuery(sql);
			 rs.afterLast();
			while(rs.next()) {
				String name = rs.getString("name");
				int id = rs.getInt(2);
				String city = rs.getString("city");
				System.out.println(name+"\t"+id+"\t"+city);
				
			}
		System.out.println();
		rs.last();
		System.out.println(rs.getString("name")+"\t"+rs.getInt(2)+"\t"+rs.getString("city"));
		rs.absolute(3);
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
