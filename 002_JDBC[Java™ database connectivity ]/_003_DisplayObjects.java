package com.te.statik;

import java.sql.*;

//example For DQL
//(Selection ,Projection ,Joins)

public class DisplayObjects {
	public static void main(String[] args) throws SQLException {
		Connection con=null;
		PreparedStatement ptmt=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//load the driver class
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems?user=root&password=root");//create the connection object
			
			String s="select * from employee"; //writing a Query it may be DQL(select) and DMl(insert update delete)
			
			ptmt=con.prepareStatement(s);
			
			rs=ptmt.executeQuery();
			while(rs.next()){         //processing the result set
				System.out.print(" \n" +rs.getInt(1)+"  "+rs.getString("ename")+" "+ rs.getInt("dept")); //getting the reslut
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ptmt.close();
		}
	}
}
