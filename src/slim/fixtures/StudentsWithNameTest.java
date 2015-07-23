package slim.fixtures;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import sut.utils.DbUtils;

/**
 * Fixture code
 * @author pbose
 *
 */
public class StudentsWithNameTest
{
	private String DB_CONN_FILE = "C:/Java/fitnesse/resources/dbcon.properties";
	private String name;
	
	public StudentsWithNameTest(String name)
	{ this.name = name; }
	
	public String getName()
	{ return name; }
	
	public void table(List<List<String>> table) 
	{}

	/**
	 * MANDATORY Method.
	 * The fixture class must have a query method that returns a list of rows (i.e.table). 
	 * Each row is a list of fields. 
	 * Each field is a two-element list composed of the field name and it's string value.
	 */
	public List<Object> query()
	{
		ArrayList<Object> table = new ArrayList<Object>();
		ArrayList<String> names = null;

		// load db connection details from properties file
		Properties p = new Properties();
		try 
		{ p.load(new FileInputStream(DB_CONN_FILE)); }
		catch (IOException e) 
		{ e.printStackTrace(); }
		
		names  = DbUtils.getStudentNames(name, p.getProperty("url"), p);
		for (int i = 0; i < names.size(); i++)
		{
			ArrayList<Object> row = new ArrayList<Object>();
			ArrayList<Object> field = new ArrayList<Object>();
			
			field.add("name");
			field.add(names.get(i));
			
			row.add(field);
			table.add(row);
		}
		
		return table;
	}
}
