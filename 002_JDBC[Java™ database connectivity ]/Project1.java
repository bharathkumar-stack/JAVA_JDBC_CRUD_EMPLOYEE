package com.te.statik;
import java.sql.*;


public class Project1 {
public static void main(String[] args) {
	Connection con =null;
	Statement stmt=null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("driver has been created ");
		
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems?user=root&password=root");
		
		//String query="insert into employee values(3,'Rthod',40)";
		//String query1="insert into employee values(10,'Rthod',40)";

		
		stmt=con.createStatement();
		
		int count =stmt.executeUpdate("insert into employee values(2,'Sai sompalli',20)");
		//int count1 =stmt.executeUpdate(query1);
		System.out.println("the number of rows effected  " +count);
		//System.out.println("the number of rows effected  " +count1);
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	finally {
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

}
