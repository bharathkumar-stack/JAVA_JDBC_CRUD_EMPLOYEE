package _001_Dynamically_Entering_Employee_Data;
import java.sql.*;
import java.util.Scanner;

public class _003_Update_Employee {
	/**use Employeeschema

Create table Employee(
empid int primary key AUTO_INCREMENT,
email varchar(50) ,
empname varchar(50),
empaddress varchar(50),
empphone varchar(10)*/

	public static void update(){
		String url ="jdbc:mysql://localhost:3306/Employeeschema";
		String username="root";
		String password1="root";
		PreparedStatement statement=null;
		try (Connection conn=DriverManager.getConnection(url, username, password1)){
			
		        String fetch="select * from Employee"; //writing a Query it may be DQL(select) and DMl(insert update delete)
	            statement=conn.prepareStatement(fetch);
				ResultSet rs=statement.executeQuery();
				while(rs.next()){         //processing the result set
				System.out.print(" \n" +rs.getInt(1)+"  "+rs.getString("email")+" "+ rs.getString("empname")+" "+ rs.getString("empaddress")+" "+ rs.getString("empphone")); //getting the reslut
				}
				
			
			String sql="update Employee set  email=?,empname=?,empaddress=?,empphone=? where empid=?";
			 statement =conn.prepareStatement(sql);
            Scanner s=new Scanner(System.in);
			System.out.println("\nupdate Email");
			String p =s.next();
			System.out.println("update EmpName");
			String f =s.next();
			System.out.println("update EmpAddress");
			String e =s.next();
			System.out.println("update EmpPhone");
			String x =s.next();
			System.out.println(" \nenter EmpId where above info to be stored");
			int u =s.nextInt();
			s.close();
			//should be in sequence with the query
			statement.setString(1,p);
			statement.setString(2,f);
			statement.setString(3,e);
			statement.setString(4,x);

			statement.setInt(5, u);
			
			boolean update_Flag=statement.execute();
			if(!update_Flag) {
				System.out.println("Update Successfull");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		update();
	}

}
