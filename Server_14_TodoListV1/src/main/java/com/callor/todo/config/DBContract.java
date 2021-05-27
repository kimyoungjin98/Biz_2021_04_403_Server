package com.callor.todo.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContract {

	private static Connection dbConn;
	
	static {
		
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/mydb";
		String user = "gbUser";
		String pw = "12345";
		
		try {
			Class.forName(driver);
			
			if(dbConn == null) {
			dbConn = DriverManager.getConnection(url, user, pw);
			}
			System.out.println("DB 접속성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static Connection getDbConn() {
		return dbConn;
	}
	
}
