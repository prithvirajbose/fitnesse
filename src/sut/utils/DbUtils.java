package sut.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

/**
 * SUT
 * @author pbose
 *
 */
public class DbUtils
{
	/**
	 * 
	 * @param filter
	 * @param dbURL
	 * @param connInfo
	 * @return
	 */
	public static ArrayList<String> getStudentNames(String filter, String dbURL, Properties connInfo)
	{
		ArrayList<String> names = new ArrayList<String>();
		ResultSet rs = null;
		
		// connect to database
		try(Connection conn = DriverManager.getConnection(dbURL, connInfo))
		{
			String sqlStmt = "SELECT name FROM student WHERE name LIKE ?";
			
			try(PreparedStatement cmd = conn.prepareStatement(sqlStmt))
			{
				cmd.setString(1, filter);
				
				rs = cmd.executeQuery();
				while (rs.next())
				{ names.add(rs.getString("NAME")); }
			}			
			catch (SQLException e) 
			{ e.printStackTrace(); }
		}
		catch (SQLException e1)
		{ e1.printStackTrace(); }
		
		return names;
	}
}
