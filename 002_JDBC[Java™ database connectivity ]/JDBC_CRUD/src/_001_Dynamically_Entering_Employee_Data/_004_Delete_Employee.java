package _001_Dynamically_Entering_Employee_Data;
import java.sql.*;
import java.util.Scanner;

public class _004_Delete_Employee {
public static  void delete_Employee() {
	Connection con=null;
	PreparedStatement s=null;
	//ResultSet r=null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Employeeschema?user=root&password=root");
				String query="delete from Employee where empid=?";
				s=con.prepareStatement(query);
				Scanner scanner=new Scanner(System.in);
				System.out.println("Enter ID to Delete ");
				int id =scanner.nextInt();
				s.setInt(1, id);
				
				int count=s.executeUpdate();
				System.out.println("delete is done ");
				System.out.println("number of rows effected "+count); 
			} catch (Exception e) {
				e.printStackTrace();
			}
}
public static void main(String[] args) {
	delete_Employee(); //Deleting The Object Of Employee is Successfully
}
}
