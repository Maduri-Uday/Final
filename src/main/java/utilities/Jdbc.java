package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;



public class Jdbc {

	public ResultSet jdbc() throws SQLException
	{
		String host="localhost";
		String port="3306";
		String username="root";
		String password="Welcome@#01";
		Connection con=	DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/jdbc",username,password);
		java.sql.Statement statement=con.createStatement();
		ResultSet rs=statement.executeQuery("select * from amazon where password='9246198354a'");
		rs.next();
			return rs;
	}
}
