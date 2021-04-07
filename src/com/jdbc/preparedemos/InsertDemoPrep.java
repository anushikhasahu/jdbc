package com.jdbc.preparedemos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertDemoPrep {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//Scanner sc = new Scanner(System.in);
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "system";
		String password = "root";
		Connection connection = null;
		PreparedStatement ps = null;

		try {	
			connection = DriverManager.getConnection(url, username, password);
			String sql = "insert into coemployee values(?,?,?)";	
			ps = connection.prepareStatement(sql);
			ps.setString(1, "rahul");	
			ps.setInt(2, 11);
			ps.setString(3, "banglore");
			ps.execute();
		
		} catch (SQLException e) {		
					// TODO Auto-generated catch block		
					e.printStackTrace();	
					} finally {		
						try {		
							if (ps != null)	
								ps.close();		
							if (connection != null)			
								connection.close();			
						//	sc.close();	
							} catch (SQLException e) {	
								// TODO Auto-generated catch block	
								e.printStackTrace();		
								}	
						}
			}
		
	

}
