package sut.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * A class to fetch capitals of countries.
 * Data is loaded from a CSV file.
 * @author pbose
 *
 */
public class CountriesUtils
{
	private static HashMap<String, String> table = new HashMap<String, String>();
	
	/**
	 * Get the country/capital pairs
	 * @return
	 */
	public static HashMap<String, String> getData()
	{ return table; }
		
	/**
	 * Search country/capital pairs based on filters.
	 * The search is case insensitive.
	 * @param filter
	 * @return
	 */
	public static HashMap<String, String> search(String filter)
	{ return caseInsensitiveSearch(filter); }
	
	/**
	 * Loads the country/capital from the file
	 * @param filename
	 */
	public static void loadFromFile(String filename)
	{
		try(BufferedReader br = new BufferedReader(new FileReader(new File(filename)));)
		{
			String line = null;
			while ((line = br.readLine()) != null)
			{
				StringTokenizer tokens = new StringTokenizer(line, ",");
				String key = null, val = null;
				
				while(tokens.hasMoreTokens())
				{
					val = tokens.nextToken().trim();
					
					if (!table.containsKey(key))
						key = val;
					
					table.put(key, val);
				}
			}
		}
		catch (FileNotFoundException e) 
		{
			System.out.println(filename + " not found");
		}
		catch (IOException e) 
		{ e.printStackTrace(); }
	}

	/**
	 * Utility method to dump the data
	 */
	public static void dump()
	{
		Iterator<String> it = getIterator();
		while (it.hasNext())
		{
			String key = it.next();
			System.out.println("Key: " + key + " Value: " + table.get(key));
		}
	}
	
	/**
	 * Gets the capital of a country.
	 * @param country
	 * @return If found returns the capital else returns null;
	 */
	public static String getCapital(String country)
	 { return table.get(country); }

	protected static Iterator<String> getIterator()
	{
		Set<String> keys = table.keySet();
		Iterator<String> it = keys.iterator();
		return it;
	}

	/**
	 * Implements case insensitive search over the data.
	 * @param filter
	 * @return
	 */
	protected static HashMap<String, String> caseInsensitiveSearch(String filter)
	{
		HashMap<String, String> results = new HashMap<String, String>();
		Iterator<String> it = getIterator();
		String key = null;
		
		while (it.hasNext())
		{
			key = it.next();
			if (key.toLowerCase().contains(filter))
				results.put(key, table.get(key));
		}
		
		return results;
	}
}
