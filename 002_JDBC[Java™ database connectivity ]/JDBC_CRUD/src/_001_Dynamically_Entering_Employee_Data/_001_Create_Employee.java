package _001_Dynamically_Entering_Employee_Data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
import java.sql.*;

public class _001_Create_Employee {
	//Code for Creating Data base and Table in MYsql 
/*use Employeeschema

Create table Employee(
empid int primary key AUTO_INCREMENT,
email varchar(50) ,
empname varchar(50),
empaddress varchar(50),
empphone varchar(10) unique
);*/ 
	public static void Insert(){
		String url ="jdbc:mysql://localhost:3306/Employeeschema";
		String username="root";
		String password="root";
		try (Connection conn=DriverManager.getConnection(url, username, password)){
			String sql="Insert into Employee(email,empname,empaddress,empphone)values(?,?,?,?)";
			PreparedStatement statement=conn.prepareStatement(sql);
			Scanner s=new Scanner(System.in);
			System.out.println("insert email");
			String u =s.next();
			System.out.println("insert empname");
			String p =s.next();
			System.out.println("insert empaddress");
			String f =s.next();
			System.out.println("insert empphone");
			String e =s.next();
			s.close();
			statement.setString(1, u);
			statement.setString(2, p);
			statement.setString(3, f);
			statement.setString(4, e);
			int rowinserted=statement.executeUpdate(); //execute update returns string
			if(rowinserted>0){
				System.out.println("A new user was inserted sucsssfull...! "+rowinserted);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	public static void main(String[] args) {
		Insert();//Inserting a DAta Employee done Successfully
	}
}
