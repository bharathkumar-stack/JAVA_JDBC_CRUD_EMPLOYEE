package com.te.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class CrudOperationMethods {
	public static void Insert(){
		String url ="jdbc:mysql://localhost:3306/sampledb";
		String username="root";
		String password="root";
		try (Connection conn=DriverManager.getConnection(url, username, password)){
			String sql="Insert into users(username,password,fullname,email)values(?,?,?,?)";
			PreparedStatement statement=conn.prepareStatement(sql);
			Scanner s=new Scanner(System.in);
			System.out.println("insert username");
			String u =s.next();
			System.out.println("insert password");
			String p =s.next();
			System.out.println("insert fullname");
			String f =s.next();
			System.out.println("insert email");
			String e =s.next();
			statement.setString(1, u);
			statement.setString(2, p);
			statement.setString(3, f);
			statement.setString(4, e);
			int rowinserted=statement.executeUpdate();
			if(rowinserted>0){
				System.out.println("A new user was inserted sucsssfull...! "+rowinserted);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void fetching(){
		String url ="jdbc:mysql://localhost:3306/sampledb";
		String username="root";
		String password="root";
		String sql="select * from users";
		Statement statement=null;
		ResultSet result=null;
		try(Connection conn=DriverManager.getConnection(url, username, password)) {
			statement=conn.createStatement();
			result =statement.executeQuery(sql);
			int count =0;
			while(result.next()){
			System.out.println(result.getInt(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4)+" "+result.getString(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
public static boolean update(){
	String url ="jdbc:mysql://localhost:3306/sampledb";
	String username="root";
	String password1="root";
	String sql="update users set password=?,fullname=?,email=? where user_id=?";
	try (Connection conn=DriverManager.getConnection(url, username, password1)){
		PreparedStatement statement =conn.prepareStatement(sql);
		Scanner s=new Scanner(System.in);
		System.out.println("update password");
		String p =s.next();
		System.out.println("update fullname");
		String f =s.next();
		System.out.println("update email");
		String e =s.next();
		System.out.println("enter userid where above info to be stored");
		String u =s.next();
		statement.setString(1, "p");
		statement.setString(2, "f");
		statement.setString(3, "e");
		statement.setString(4, "u");
		System.out.println("update susscfull");
	} catch (Exception e) {
		e.printStackTrace();
	}
	return false;
	
}
public static void main(String[] args) {

}
}
