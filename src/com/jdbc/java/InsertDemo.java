package com.jdbc.java;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertDemo {

	public static void main(String[] args) {
		//String sql = "insert into costudent values('ram',10,'banglore')";
		Scanner sc = new Scanner(System.in);
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "system";
		String password = "root";

		Connection connection = null;
		Statement statement = null;
		// establish a connection

		
		
		try {	
			connection = DriverManager.getConnection(url, username, password);
			// Create a Statement object and add the query		
			statement = connection.createStatement();	
			for (int i = 0; i < 4; i++) {			
				System.out.println("Enter Student Name");		
				String name = sc.next();			
				System.out.println("Enter Student ID");		
				int id = sc.nextInt();			
				System.out.println("Enter Student City");	
				String city = sc.next();		
				String sql = "insert into coStudent values ('" + name + "'," + id + ",'" + city + "')";	
				// Execute the Statement		
				boolean result = statement.execute(sql);		
				System.out.println("Inserted " + result);		
				}		} catch (SQLException e) {		
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


