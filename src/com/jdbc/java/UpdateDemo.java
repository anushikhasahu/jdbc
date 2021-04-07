package com.jdbc.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateDemo {

	public static void main(String[] args) {

		// String sql = "insert into costudent values('ram',10,'banglore')";
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
			System.out.println("enter choice name or city");
			String choice = sc.next();
			int id = sc.nextInt();
			System.out.println("enter id to updated");
			String sql = null;
			boolean result = true;

			if (choice.equals("c")) {
				System.out.println("enter city");
				String city = sc.next();
				sql = "update costudent set city= ' " + city + "' where studId=" + id;
				result = statement.execute(sql);
			} else if (choice.equals("n")) {
				System.out.println("enter name");
				String name = sc.next();
				sql = "update costudent set name= ' " + name + "' where studId=" + id;
				result = statement.execute(sql);
			} else {
				System.out.println("wrong choice");
			}
			System.out.println("updated " + (!result));
			System.out.println("enter id to delete");
			id = sc.nextInt();
			sql = "delete from costudent where studId=" + id;
			result = statement.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (sc != null)
					sc.close();
				if (statement != null)
					statement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
