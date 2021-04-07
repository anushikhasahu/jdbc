package com.exer.sport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Insert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

Scanner sc = new Scanner(System.in);
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "system";
		String password = "root";

		Connection connection = null;
		PreparedStatement statement = null;
		

		
		
		try {	
			connection = DriverManager.getConnection(url, username, password);
			String sql = "insert into sports(name,spid,coach) values(?,?,?)";	
			statement = connection.prepareStatement(sql);	
			for (int i = 0; i < 2; i++) {			
				System.out.println("Enter  Name");		
				String name = sc.next();			
				System.out.println("Enter  ID");		
				int id = sc.nextInt();			
				System.out.println("Enter  Coach");	
				String coach = sc.next();		
				//String sql = "insert into coStudent values ('" + name + "'," + id + ",'" + city + "')";	
					
				statement.setString(1, name);
				statement.setInt(2, id);
				statement.setString(3, coach);
				statement.execute();
				
				}	} catch (SQLException e) {		
					// TODO Auto-generated catch block		
					e.printStackTrace();	
					} finally {		
						try {		
							if (statement != null)	
								statement.close();		
							if (connection != null)			
								connection.close();			
							sc.close();	
							} catch (SQLException e) {	
								// TODO Auto-generated catch block	
								e.printStackTrace();		
								}	
						}
		
		
		
		
		
		
		
		
	}

}
