package com.ayan.jdbcTest;
import java.sql.Connection;
import java.sql.DriverManager;

// this class is for simple jdbc connection testing
public class TestJdbc {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-03-one-to-many?useSSL=false&serverTimezone=UTC";
		String user = "root";
		String pass = "ayan@9851571961";
		
		try {
			System.out.println("Connecting to database: " + jdbcUrl);
			
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("Connection successful!!! ");
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}

}
