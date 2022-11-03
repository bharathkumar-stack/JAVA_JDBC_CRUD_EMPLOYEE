package com.te.statik;

import java.sql.*;

public class DeleteEmployee {
public static void main(String[] args) {
	Connection con=null;
	Statement s=null;
	ResultSet r=null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems?user=root&password=root");
				
				
				s=con.createStatement();
				int count=s.executeUpdate("delete from employee where id=1");
				System.out.println("delete is done ");
				System.out.println("number of rows effected "+count);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
}
}
