package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DB {
		Connection connect;
		Statement statement;
	public DB(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("[DB] Driver Loaded");
			String User = "root";
			String Url = "jdbc:mysql://localhost:3306/estore";
			String Password = "anujqwerty32";
			connect  = DriverManager.getConnection(Url, User, Password);
			System.out.println("[DB] Database Connected");
			statement = connect.createStatement();
			System.out.println("[DB] Statement Created");
		}
		catch(Exception e) {
			System.out.println("[DB] Something went wrong"+e);
		}
	}
	public int executeSQL(String sql) {
		int res = 0;
		try {
			res = statement.executeUpdate(sql);
			System.out.println("[DB] SQL Statement Executed ");
		}
		catch(Exception e) {
			System.out.println("[DB] Something went wrong in executeSQL"+e);
		}
		return res;
		
	}
	public void closeConnection() {
		try {
			connect.close();
			System.out.println("[DB] Connection closed");
		}
		catch(Exception e){
			System.out.println("[DB] Exception in closeConnection()");
		}
	}
}
