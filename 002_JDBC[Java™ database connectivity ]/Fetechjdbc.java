package com.te.statik;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Fetechjdbc {
public static void main(String[] args) {
Connection con =null;
PreparedStatement p=null;
ResultSet rs=null;
try {
	Class.forName("com.mysql.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems?user=root&password=root");
	String s="select * from employee where id=?";
	p.setInt(1, 1);
	p=con.prepareStatement(s);
	
	rs=p.executeQuery();
	
	while(rs.next()){
		System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
	}
	} catch (Exception e) {
	e.printStackTrace();
}
}
}
