package _001_Dynamically_Entering_Employee_Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class _002_Display_Employee {
	public static void DisplayObjects() {
		Connection con=null;
		PreparedStatement ptmt=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//load the driver class
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Employeeschema?user=root&password=root");//create the connection object
			String s="select * from Employee"; //writing a Query it may be DQL(select) and DMl(insert update delete)
			ptmt=con.prepareStatement(s);
			rs=ptmt.executeQuery();
			while(rs.next()){         //processing the result set
			System.out.print(" \n" +rs.getInt(1)+"  "+rs.getString("email")+" "+ rs.getString("empname")+" "+ rs.getString("empaddress")+" "+ rs.getString("empphone")); //getting the reslut
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				con.close();
				ptmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		DisplayObjects();//Displaying Employee is Done Successfully..!
	}
}
