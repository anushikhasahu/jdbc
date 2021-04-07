package com.jdbc.preparedemos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultPrepDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "system";
		String password = "root";

		Connection connection = null;
	 PreparedStatement ps = null;
		

		try {
			connection = DriverManager.getConnection(url, username, password);
			String sql = "Select * from coemployee where city = ?";
			
			ps = connection.prepareStatement(sql);
		ps.setString(1, "lok");
			// execute the statement and pass the query
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String name = rs.getString("name");
				int id = rs.getInt("empid");
				String city = rs.getString("city");
				System.out.println(name+"\t"+id+"\t"+city);
				
			}
		//	System.out.println("table created " + result);
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
