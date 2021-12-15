package JDBCpractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class ExecuteQuery {
	
	@Test
	public void executeQueryTest() throws Throwable
	{
		//Step 2 connect to database
		Connection con=null;
		try 
		{
			//Step 1 Register the driver
			Driver dref= new Driver();
			DriverManager.registerDriver(dref);
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
			
			//Step 3 create a statement
			Statement stmt = con.createStatement();

			//Step 4 execute query
			ResultSet result = stmt.executeQuery("select * from student_info;");
			while(result.next())
			{
			System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4));
			}
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Step 5 close the connection
		finally
		{
		con.close();
		}
	}

}
