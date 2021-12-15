package JDBCpractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class ExecuteUpdate {
	
	@Test
	public void executeUpdateTest() throws SQLException
	{
		Connection con=null;
		try {
			// step1 register the driver
			Driver dref=new Driver();
			DriverManager.registerDriver(dref);
			
			//step2 connect to the database
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
			
			//step3 create statement
			Statement stmt = con.createStatement();
			
			//step4 execute query here returns int value
			int res = stmt.executeUpdate("insert into student_info(regno,firstname,lastname,middlename) values('5','preeti','V','varun');");
			if(res==1)
			{
				System.out.println("Execute update passed");
			}
			else
			{
				System.out.println("Execute update failed");
			}
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			//close the connection
			con.close();
		}
	}

}
