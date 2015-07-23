package slim.fixtures;

import java.util.HashMap;

import sut.utils.CountriesUtils;

/**
 * Notice there is no biz logic in the fixture code, only method call delegation.
 * @author pbose
 *
 */
public class CountriesTest
{
	private HashMap<String, String> searchResults = null;
	private String capital;
	
	public CountriesTest() {}

	public void loadCountriesFromFile(String filename)
	{ CountriesUtils.loadFromFile(filename); }
	
	public boolean countryListSize(int size)
	{ return CountriesUtils.getData().size() == size; }

	public boolean searchListSize(int size)
	{ return searchResults.size() == size; }
	
	public void search(String filter)
	{ searchResults = CountriesUtils.search(filter); }
	
	public boolean contains(String country)
	{ return searchResults.containsKey(country); }
	
	public void getCapital(String country)
	{ capital = CountriesUtils.getCapital(country); }
	
	public String capital()
	{ return capital; }
}
