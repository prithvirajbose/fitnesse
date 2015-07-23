package slim.fixtures;

public class InsertNumberTest
{
	private int [] iArray = null;
	private int number;
	
	public InsertNumberTest(int [] iArray)
	{ this.iArray = iArray; }
	
	/**
	 * If array index out of bounds then return false
	 * else insert.
	 * @param val
	 * @param index
	 * @return
	 */
	public boolean insertAtIndex(int val, int index)
	{
		if (index > iArray.length)
			return false;
		else
		{
			iArray[index] = val; 
			return true;
		}
	}
	
	/**
	 * If array index out of bounds then return false
	 * else return number.
	 * @param index
	 * @return
	 */
	public boolean getNumberAtIndex(int index)
	{ 
		if (index > iArray.length)
			return false;
		else
		{
			number = iArray[index]; 
			return true;
		}
	}
	
	public int number()
	{ return number; }
}
